package com.example.manageprojectemployeeretro.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String code;
    private List<Integer> roleIds;

    public void getRoleIds(List<Integer> roleIds) {
        int n = 1;
        for (Integer roleId : roleIds) {
            roleId = n++;
        }
        this.roleIds = roleIds;
    }
}
