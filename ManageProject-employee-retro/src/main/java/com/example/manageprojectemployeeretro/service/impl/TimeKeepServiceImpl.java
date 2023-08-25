package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dao.TimekeepingRepository;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.dto.TimekeepingDTO;
import com.example.manageprojectemployeeretro.projection.TimekeepingProjection;
import com.example.manageprojectemployeeretro.entity.Timekeeping;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.exception.CheckInException;
import com.example.manageprojectemployeeretro.exception.NotFoundException;
import com.example.manageprojectemployeeretro.service.TimeKeepService;
import com.example.manageprojectemployeeretro.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeKeepServiceImpl implements TimeKeepService {
    private final TimekeepingRepository timekeepingRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public TimekeepingDTO checkin(Integer code) {
        User user = userRepository.findByCode(code);
        if (user == null){
            throw new NotFoundException(Constants.EMPLOYEE_IS_NULL);
        }
        boolean hasCheckInOut = timekeepingRepository.existsByUserAndCheckOutTimeIsNull(user);
        if (hasCheckInOut) {
            throw new CheckInException(Constants.CHECK_IN_SUCCESSFULLY);
        }
        Timekeeping timekeeping = new Timekeeping();
        timekeeping.setUser(user);
        timekeeping.setCheckInTime(LocalDateTime.now());
        timekeeping.setDate(LocalDate.now());
        Timekeeping saveTimekeeping = timekeepingRepository.save(timekeeping);
        return mapper.map(saveTimekeeping, TimekeepingDTO.class);
    }


    @Override
    public TimekeepingDTO checkout(Integer code) {
        User user = userRepository.findByCode(code);
        if (user == null){
            throw new NotFoundException(Constants.EMPLOYEE_IS_NULL);
        }
        Timekeeping checkInOut  = timekeepingRepository.findByUserAndCheckOutTimeIsNull(user);
        if (checkInOut  == null) {
            throw new CheckInException(Constants.CHECK_OUT_SUCCESSFULLY);
        }
        checkInOut.setCheckOutTime(LocalDateTime.now());
        Timekeeping saveTimekeeping = timekeepingRepository.save(checkInOut);
        return mapper.map(saveTimekeeping, TimekeepingDTO.class);
    }

    @Override
    public List<TimekeepingProjection> getCheckInOutByUserAndDateRange(Integer userId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        if (startDate == null) {
            startDate = LocalDate.now().with(DayOfWeek.MONDAY); // Tuần hiện tại từ thứ 2
        }
        if (endDate == null) {
            endDate = startDate.plusDays(6); // Tuần hiện tại đến chủ nhật
        }
        return timekeepingRepository.findTimekeepingByUserAndDateBetween(userId, startDate, endDate);
    }

    @Override
    public List<Timekeeping> getErrorCheckInsByUserAndMonth(Integer userId, int year, int month) {
        User user = new User();
        user.setId(userId);
        return timekeepingRepository.findErrorCheckInsByUserAndMonth(user,year,month);
    }
}

