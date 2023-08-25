package com.example.manageprojectemployeeretro.projection;

import java.time.LocalDateTime;

public interface TimekeepingProjection {
    LocalDateTime getCheckInTime();
    LocalDateTime getCheckOutTime();
}
