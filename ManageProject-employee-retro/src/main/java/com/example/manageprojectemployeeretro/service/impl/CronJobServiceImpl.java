package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dao.CronJobRepository;
import com.example.manageprojectemployeeretro.entity.CronJob;
import com.example.manageprojectemployeeretro.service.CronJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CronJobServiceImpl implements CronJobService {
    private final CronJobRepository cronJobRepository;

    @Override
    public List<CronJob> getAllCronJobs() {
        return cronJobRepository.findAll();
    }

    @Override
    public CronJob getCronJobById(Long id) {
        return cronJobRepository.findById(id).orElse(null);
    }

    @Override
    public CronJob saveCronJob(CronJob cronJob) {
        return cronJobRepository.save(cronJob);
    }

    @Override
    public void deleteCronJob(Long id) {
        cronJobRepository.deleteById(id);
    }
}
