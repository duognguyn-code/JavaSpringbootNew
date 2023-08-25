package com.example.manageprojectemployeeretro.scheduled;

import com.example.manageprojectemployeeretro.entity.CronJob;
import com.example.manageprojectemployeeretro.service.CronJobService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CronJobScheduler {

    private final ApplicationContext applicationContext;
    private final SchedulerFactoryBean schedulerFactoryBean;

    private final CronJobService cronJobService;


    @Bean
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        // Lấy danh sách công việc cron từ cơ sở dữ liệu
        List<CronJob> cronJobs = getCronJobsFromDatabase();

        // Lặp qua từng công việc cron và lập lịch
        for (CronJob cronJob : cronJobs) {
            JobDetail jobDetail = buildJobDetail(cronJob);
            Trigger trigger = buildCronTrigger(cronJob);
            scheduler.scheduleJob(jobDetail, trigger);
        }

        scheduler.start();
    }

    private List<CronJob> getCronJobsFromDatabase() {
        // Gọi phương thức từ service hoặc repository để lấy danh sách công việc cron từ cơ sở dữ liệu
        return cronJobService.getAllCronJobs();
    }

    public JobDetail buildJobDetail(CronJob cronJob) {
        // Tạo JobDetail với công việc cần thực thi
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobCommand", cronJob.getJobCommand());
        jobDataMap.put("jobParameters", cronJob.getJobParameters());

        return JobBuilder.newJob(CronJobExecutor.class)
                .withIdentity(cronJob.getId().toString())
                .setJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    public Trigger buildCronTrigger(CronJob cronJob) {
        // Tạo CronTrigger với biểu thức cron
        return TriggerBuilder.newTrigger()
                .forJob(cronJob.getId().toString())
                .withIdentity(cronJob.getId().toString() + "_trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronJob.getCronExpression()))
                .build();
    }
}


