package com.example.manageprojectemployeeretro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String username;
    private String checkin;
    private String checkout;
    private Date createAt;

}
