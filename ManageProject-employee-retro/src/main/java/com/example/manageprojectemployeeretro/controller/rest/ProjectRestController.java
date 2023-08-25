package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiProject")
@RequiredArgsConstructor
public class ProjectRestController {
    private final ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<Page<Project>> getProjects(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Project> projectPage = projectService.getAllProject(pageable);
        return ResponseEntity.ok(projectPage);
    }
}
