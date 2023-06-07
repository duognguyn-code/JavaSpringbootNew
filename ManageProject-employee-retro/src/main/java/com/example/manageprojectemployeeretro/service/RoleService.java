package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRole();
    Role findRoleById(int id);
}
