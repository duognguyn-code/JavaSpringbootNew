package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userDAO;


    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    public void createUser(User user) {
        userDAO.save(user);

    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
       return userDAO.save(user);
    }


    @Override
    public void saveUser(List<User> users) {
        userDAO.saveAll(users);

    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public User getUserByEmail(String emailSI) {
        return userDAO.getUserBymail(emailSI);
    }

    @Override
    public boolean checkLogin(String email, String pass) {
        User optionalUser = userDAO.getUserBymail(email);
        if(optionalUser != null && optionalUser.getPassword().equals(pass)){
            return  true;
        }
        return false;
    }
    public void processOAuthPostLogin(String email) {
        User existUser = userDAO.getUserBymail(email);

        if (existUser == null) {
            User newUser = new User();
            newUser.setEmail(email);

            userDAO.save(newUser);

            System.out.println("Created new user: " + email);
        }

    }
}
