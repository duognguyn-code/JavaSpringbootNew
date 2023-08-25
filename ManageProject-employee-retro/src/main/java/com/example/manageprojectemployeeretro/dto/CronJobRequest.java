package com.example.manageprojectemployeeretro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CronJobRequest {
    private String cronExpression;
//    để lưu trữ lệnh cụ thể cần thực hiện cho công việc lập lịch
    private String jobCommand;
//    để lưu trữ thông tin về các tham số liên quan đến công việc lập lịch.
    private Map<String, String> jobParameters;
}
