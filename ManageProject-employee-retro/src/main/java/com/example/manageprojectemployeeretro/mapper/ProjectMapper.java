package com.example.manageprojectemployeeretro.mapper;

import com.example.manageprojectemployeeretro.dto.ProjectDTO;
import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.utils.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(source = "name", target = "name")
    ProjectDTO projectToProjectDTO(Project project);
//    mapping map rolename từ user sang userdto
    Project toEntity(ProjectDTO projectDTO);


}
