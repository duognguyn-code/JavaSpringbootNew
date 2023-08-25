package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);

    List<User> getAllUser();

    String getAllUserWithLastName();

    User getUserByUserName(String username);
    void createUser(User user);

    User findUserById(int id);

    void deleteUserById(int id);
    User updateUser(User user);

    public List<UserDTO> getAllResponseDTO();

    void saveUser(List<User> users);
    List<User> getUsersByProjectId(Long projectId);

    public void insertUser(String firstName, String lastName, String password, String phone, Long roleId, Long projectId);

     User getDataUserAndRole();
}
