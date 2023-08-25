package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dto.CronJobRequest;
import com.example.manageprojectemployeeretro.entity.CronJob;
import com.example.manageprojectemployeeretro.scheduled.CronJobExecutor;
import com.example.manageprojectemployeeretro.service.CronJobService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cron-jobs")
@RequiredArgsConstructor
public class CronJobController {
    private final CronJobService cronJobService;
    private final SchedulerFactoryBean schedulerFactoryBean;
//"cronExpression": "0 0/5 * * * ?",
//    "jobCommand": "myJobCommand",
//    "jobParameters": {
//        "param1": "value1",
//        "param2": "value2"
//    }
    @PostMapping
    public ResponseEntity<?> createCronJob(@RequestBody CronJobRequest cronJobRequest) {
        try {
            if (CronExpression.isValidExpression(cronJobRequest.getCronExpression())) {
                CronJob cronJob = new CronJob();
                cronJob.setCronExpression(cronJobRequest.getCronExpression());
                // Set other properties of cronJob based on cronJobRequest

                cronJobService.saveCronJob(cronJob);

                Scheduler scheduler = schedulerFactoryBean.getScheduler();
                JobDetail jobDetail = buildJobDetail(cronJob);
                Trigger trigger = buildCronTrigger(cronJob);
                scheduler.scheduleJob(jobDetail, trigger);

                return ResponseEntity.ok("Cron job created successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid cron expression");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCronExpression(@PathVariable Long id, @RequestBody String cronExpression) {
        try {
            CronJob cronJob = cronJobService.getCronJobById(id);
            if (cronJob == null) {
                return ResponseEntity.notFound().build();
            }
            if (CronExpression.isValidExpression(cronExpression)) {

                cronJob.setCronExpression(cronExpression);
                cronJobService.saveCronJob(cronJob);


                return ResponseEntity.ok("Cron expression updated successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid cron expression");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCronJob(@PathVariable Long id) {
        try {
            CronJob cronJob = cronJobService.getCronJobById(id);
            if (cronJob == null) {
                return ResponseEntity.notFound().build();
            }

            cronJobService.deleteCronJob(id);

            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(cronJob.getId().toString());
            scheduler.deleteJob(jobKey);

            return ResponseEntity.ok("Cron job deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    private JobDetail buildJobDetail(CronJob cronJob) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobCommand", cronJob.getJobCommand());
        jobDataMap.put("jobParameters", cronJob.getJobParameters());

        return JobBuilder.newJob(CronJobExecutor.class)
                .withIdentity(cronJob.getId().toString())
                .setJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildCronTrigger(CronJob cronJob) {
        return TriggerBuilder.newTrigger()
                .forJob(cronJob.getId().toString())
                .withIdentity(cronJob.getId().toString() + "_trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronJob.getCronExpression()))
                .build();
    }
}
