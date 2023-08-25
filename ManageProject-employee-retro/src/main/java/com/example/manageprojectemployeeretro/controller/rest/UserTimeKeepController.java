package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.exception.Response;
import com.example.manageprojectemployeeretro.service.UserForCheckin;
import com.example.manageprojectemployeeretro.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserTimeKeepController {
    private final UserForCheckin userService;

    @GetMapping("time-keep-between-date-emp/{id}")
    public Response findTimkeepBetweenDateByEmployee(@PathVariable Long id, @RequestParam(value = "start", required = false) Optional<String> start, @RequestParam(value = "end", required = false) Optional<String> end) {
        if (start.isPresent() && end.isPresent()) {
            return Response.success("Get successful Timekeeping").withData(userService.fillAllTimkeepingByEMP(id, Constants.stringToDate(start.get()), Constants.stringToDate(end.get())));
        } else {
            return Response.success("Get successful Timekeeping").withData(userService.fillAllTimkeepingByEMP(id, new Date(Constants.getStartWeekAndEndWeekNow()[0].getTime()), new Date(Constants.getStartWeekAndEndWeekNow()[1].getTime())));
        }
    }

    @GetMapping("time-keep-user-not-checkin")
    public Response findUserNotCheckinOrError(@RequestParam(value = "month", required = false) Optional<Integer> month) {
        return Response.success("Get successful Timekeeping").withData(userService.findUserNotCheckinOrError(month));
    }

    @GetMapping("time-keep-user-not-checkin-by-emp/{id}")
    public Response findUserNotCheckinOrErrorByEMP(@PathVariable Long id, @RequestParam(value = "month", required = false) Optional<Integer> month) {
        return Response.success("Get successful Timekeeping").withData(userService.findUserNotCheckinOrErrorByEMP(month, id));
    }
}
