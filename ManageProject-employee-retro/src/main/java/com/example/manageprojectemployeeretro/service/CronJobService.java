package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.CronJob;

import java.util.List;

public interface CronJobService {
    List<CronJob> getAllCronJobs();
    CronJob getCronJobById(Long id);
    CronJob saveCronJob(CronJob cronJob);
    void deleteCronJob(Long id);
}
