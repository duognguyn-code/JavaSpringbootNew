package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProJect();

    Project findProjectById(long id);

    Project saveProject(Project project);

    void deleteProjectById(long id);
    Page<Project> getAllUsers(Pageable pageable);
}
