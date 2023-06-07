package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.entity.Role;
import com.example.manageprojectemployeeretro.service.RoleService;
import com.example.manageprojectemployeeretro.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        return roleRepository.getRoleById(id);
    }
}
