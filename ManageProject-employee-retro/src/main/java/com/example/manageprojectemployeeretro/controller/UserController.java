package com.example.manageprojectemployeeretro.controller;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.entity.Role;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.RoleService;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/apiForTemplate/users")
public class UserController {
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;


    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUserWithResponbody() {
        return userService.getAllUser();
    }

    @GetMapping("/pageLogin")
    public String pagelogin() {
        return "redirect:/admin/adminUser/Login.html";
    }

    @GetMapping("listUser")
    @ResponseBody
    public Page<User> getAcc(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        List<User> userList = userService.getAllUser();

        Collections.reverse(userList);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), userList.size());

        List<User> currentPageList = userList.subList(start, end);

        Page<User> userPage = new PageImpl<>(currentPageList, pageable, userList.size());
        return userPage;
    }


    @GetMapping("delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "Success";
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String postUserAdd(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
//        Role role = roleService.findRoleById((int) userDTO.getRoleId());
//        Project projects = projectService.findProjectById(userDTO.getProjectId());
//        user.setProjects(projects);
        userService.updateUser(user);
        return "redirect:/api1/users/listUser";
    }

    @GetMapping("viewUpdate/{id}")
    public String viewUpdateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.findUserById(id));
        model.addAttribute("roles", roleService.getAllRole());
        model.addAttribute("projects", projectService.getAllProJect());
        return "update-user";
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProject(@PathVariable("id") int id, UserDTO userDTO) {
        User user = userService.findUserById(id);

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());

//        Role role = roleService.findRoleById((int) userDTO.getRoleId());
//        Project projects = projectService.findProjectById(userDTO.getProjectId());
//        user.setProjects(projects);

        userService.createUser(user);

        return "redirect:/api1/project/listProject";
    }

    @GetMapping("getDataByProjectId")
    public String getUsersByProjectId(@RequestParam("project_id") Long projectId, Model model) {
        List<User> users = userService.getUsersByProjectId(projectId);
        model.addAttribute("users", users);
        return "main"; // Trả về tên của view template để hiển thị danh sách người dùng
    }

    //    request gasn gias trij leen duowng daXN THEO KEYVALUE
    @GetMapping(value = "user")
    public ResponseEntity<?> getAndSaveListUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://stg-api-hrmv2.nccsoft.vn/api/services/app/CheckIn/GetUserForCheckIn";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<String> rs = Collections.singletonList(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        JsonNode resultNode = rootNode.get("result");
        List<User> users = mapper.readValue(resultNode.toString(), new TypeReference<List<User>>() {
        });
        for (User user : users) {
            System.out.println(user);
        }


        userService.saveUser(users);

        return new ResponseEntity<>("luu thanh cong", HttpStatus.OK);
    }
}
