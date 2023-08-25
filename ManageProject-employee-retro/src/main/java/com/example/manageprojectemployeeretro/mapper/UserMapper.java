package com.example.manageprojectemployeeretro.mapper;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.utils.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper  {
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    @Mapping(source = "projects.name", target = "projectName")
    UserDTO userToUserDTO(User user);
}
