package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ApiService {
    private static final String API_URL = "https://63344d73433198e79dd52e49.mockapi.io/products";

    @Autowired
    private RestTemplate restTemplate;

    public List<UserDTO> getUsers(int page, int pageSize) {
        String url = API_URL + "?page=" + page + "&limit=" + pageSize;
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(url, UserDTO[].class);
        UserDTO[] usersArray = response.getBody();
        if (usersArray != null) {
            return Arrays.asList(usersArray);
        } else {
            return Collections.emptyList();
        }
    }
    public UserDTO getUserById(String email) {
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(API_URL + email, UserDTO.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    public UserDTO createUser(UserDTO users) {
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(API_URL, users, UserDTO.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        }
        return null;
    }

    public void updateUser(String id, UserDTO users) {
        restTemplate.put(API_URL + id, users);
    }

    public void deleteUser(String email) {
        UserDTO userDTO = getUserById(email);
        if (userDTO != null) {
            restTemplate.delete(API_URL + email);
        } else{
            System.out.println("Không thấy");
        }
    }
}
