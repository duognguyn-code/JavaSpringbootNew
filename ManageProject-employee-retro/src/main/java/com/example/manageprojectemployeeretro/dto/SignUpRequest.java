package com.example.manageprojectemployeeretro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String email;
    private Integer code;
    private Integer projectId;
    private Set<String> role;
}
