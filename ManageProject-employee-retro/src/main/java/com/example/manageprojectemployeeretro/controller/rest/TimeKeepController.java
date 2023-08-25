package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.dto.TimekeepingDTO;
import com.example.manageprojectemployeeretro.projection.TimekeepingProjection;
import com.example.manageprojectemployeeretro.service.TimeKeepService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/time-keep")
@RequiredArgsConstructor
public class TimeKeepController {
    private final TimeKeepService timeKeepService;


    UserRepository userService;



    @GetMapping("/checkin/{code}")
    public TimekeepingDTO checkin(@PathVariable String code) {
        Integer codeUser = Integer.parseInt(code);
        return timeKeepService.checkin(Integer.valueOf(code));
    }

    @GetMapping("/checkout/{code}")
    public TimekeepingDTO checkout(@PathVariable String code) {
        Integer codeUser = Integer.parseInt(code);
        return timeKeepService.checkout(Integer.valueOf(code));
    }

    @GetMapping("/user/{userId}")
    public List<TimekeepingProjection> getCheckInOutByEmployeeAndDateRange(
            @PathVariable Integer userId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        return timeKeepService.getCheckInOutByUserAndDateRange(userId, startDate, endDate);
    }
}
