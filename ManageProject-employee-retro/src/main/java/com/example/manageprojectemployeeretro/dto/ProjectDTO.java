package com.example.manageprojectemployeeretro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    public Long id;
    public String name;
    public String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate endDate;

    public List<UserDTO> users;
}
