package com.example.manageprojectemployeeretro.scheduled;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CronJobExecutor implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String jobCommand = jobDataMap.getString("jobCommand");
        Map<String, Object> jobParameters = (Map<String, Object>) jobDataMap.get("jobParameters");
        System.out.println("Dynamic cron is runing");

    }
}