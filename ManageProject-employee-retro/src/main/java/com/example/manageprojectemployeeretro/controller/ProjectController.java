package com.example.manageprojectemployeeretro.controller;

import com.example.manageprojectemployeeretro.dto.ProjectDTO;
import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;


@Controller
@RequestMapping("api1/project")
public class ProjectController {
    private static final Logger logger = Logger.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @GetMapping("listProject")
    public String viewProject(@RequestParam(defaultValue = "0") int page, Model model){
        int pageSize = 10;
        Pageable pageable =  PageRequest.of(page, pageSize);
        List<Project> projects = projectService.getAllProJect();

        Collections.reverse(projects);
        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), projects.size());

        List<Project> currentPageList = projects.subList(start, end);
        Page<Project> projectPage = new PageImpl<>(currentPageList, pageable, projects.size());
        model.addAttribute("projectPage", projectPage);
        model.addAttribute("currentPage", page);
//        model.addAttribute("projects", projectService.getAllProJect());
        return "project-list";
    }
    @RequestMapping(value = "createProject",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String postProjectAdd(ProjectDTO projectDTO){
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setEndDate(projectDTO.getEndDate());
        project.setStartDate(projectDTO.getStartDate());
        projectService.saveProject(project);
        return "redirect:/api1/project/listProject";
    }
    @GetMapping("delete/{id}")
    public String deleteProject(@PathVariable int id){
        projectService.deleteProjectById(id);
        return "redirect:/api1/project/listProject";
    }

    @GetMapping("viewUpdate/{id}")
    public String viewUpdateProject(@PathVariable("id") Long id, Model model){
        model.addAttribute("project", projectService.findProjectById(id));
        return "update-project";
    }
    @RequestMapping(value = "updateProject/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProject(@PathVariable("id") Long id, ProjectDTO projectDTO) {
        Project project = projectService.findProjectById(id);

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setEndDate(projectDTO.getEndDate());
        project.setStartDate(projectDTO.getStartDate());


        projectService.saveProject(project);

        return "redirect:/api1/project/listProject";
    }
}
