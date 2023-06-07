package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    List<User> getAllUser();
    void createUser(User user);

    User findUserById(int id);



    void deleteUserById(int id);
    User updateUser(User user);


    void saveUser(List<User> users);
    Optional<User> getUserById(int id);

    User getUserByEmail(String emailSI);

    boolean checkLogin(String email, String pass);
}
