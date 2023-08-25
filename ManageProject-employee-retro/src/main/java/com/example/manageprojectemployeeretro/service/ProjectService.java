package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.projection.ProjectProjection;
import com.example.manageprojectemployeeretro.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProjectService {
    List<Project> getAllProJect();

    Project findProjectById(long id);

    Project saveProject(Project project);

    void deleteProjectById(long id);

    List<ProjectProjection> findProjectsByName(String name);
    Page<Project> getAllProject(Pageable pageable);
}
