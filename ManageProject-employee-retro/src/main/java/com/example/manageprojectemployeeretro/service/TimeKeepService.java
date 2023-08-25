package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.dto.TimekeepingDTO;
import com.example.manageprojectemployeeretro.projection.TimekeepingProjection;
import com.example.manageprojectemployeeretro.entity.Timekeeping;

import java.time.LocalDate;
import java.util.List;

public interface TimeKeepService {
    TimekeepingDTO checkin(Integer code);

    TimekeepingDTO checkout(Integer code);

    List<TimekeepingProjection> getCheckInOutByUserAndDateRange(Integer userId, LocalDate startDate, LocalDate endDate);
    List<Timekeeping> getErrorCheckInsByUserAndMonth(Integer userId, int year, int month);
}
