package com.example.manageprojectemployeeretro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TimekeepingDTO {
    private int id;
    private int employeeId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean isError;
}
