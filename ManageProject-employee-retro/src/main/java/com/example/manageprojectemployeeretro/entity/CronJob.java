package com.example.manageprojectemployeeretro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cron_jobs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CronJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "job_command")
    private String jobCommand;

    @Column(name = "job_parameters")
    private String jobParameters;
}
