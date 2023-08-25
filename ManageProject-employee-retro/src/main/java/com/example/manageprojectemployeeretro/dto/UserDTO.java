package com.example.manageprojectemployeeretro.dto;


import com.example.manageprojectemployeeretro.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String fullname;
    private String username;
    private String email;
    private String role;
    private String phone;
    private String password;
    private String projectName;
    private String code;
    //    private List<ERole> roleNames;
    private List<TimekeepingDTO> checkInRecords;
    private List<TimekeepingDTO> checkOutRecords;

}
