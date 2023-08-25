package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.service.impl.EmailServiceImpl;
import org.springframework.data.domain.Page;
import com.example.manageprojectemployeeretro.config.Config;
import com.example.manageprojectemployeeretro.config.TransactionConfig;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.projection.ProjectProjection;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.RoleService;
import com.example.manageprojectemployeeretro.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/apiUser")
public class UserRestController {
    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private TransactionConfig transactionConfig;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    public Config config;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private Environment env;

    @GetMapping("/exampleENV")
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public void getPropertyExample() {
        String propertyValue = env.getProperty("message");
        System.out.println(propertyValue);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);


    @GetMapping("/users/{userId}/role")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUserRoleName(@PathVariable int userId) {
        User user = userRepository.findUserById(userId);
        String userID = String.valueOf(userRepository.findUserById(userId));

        return userID;
    }

    @GetMapping("/testDataUseValue")
    public ResponseEntity testDataUsevalue() {
        return ResponseEntity.ok(config.Getdata());
    }

    @GetMapping("/testUseEnvironment")
    public ResponseEntity testUseEnvironment() {
        return ResponseEntity.ok(transactionConfig.getdata());
    }

    @GetMapping("")
    public ResponseEntity getAllUserForLazyAndEager() {
        try {
            return ResponseEntity.ok(userService.getAllUserWithLastName());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping("/getallRole")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(roleService.getAllRole());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/getallproject")
    public ResponseEntity getAllProject() {
        try {
            return ResponseEntity.ok(projectService.getAllProJect());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping("/getallUserwithUsername")
    public String getallUserwithUsername() {
            String user = String.valueOf(userService.getUserByUserName("anhladuong123"));
            System.out.println(user);
            return user;
    }
    @GetMapping(value = "/projectByname/{name}")
    public ResponseEntity<List<ProjectProjection>> getProjectByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(projectService.findProjectsByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/createUsers/even")
    public ResponseEntity<String> createUser(User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/users/listUser")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> userPage =  userService.getAllUsers(pageable);

        return ResponseEntity.ok(userPage);
    }

    @GetMapping("/users/listUserwithRole")
    public ResponseEntity<User> getAllUsersWithRole() {
        try {
            return ResponseEntity.ok(userService.getDataUserAndRole());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/responseToDTO")
    public List<UserDTO> getAllUsersResponseENtity() {
        return userService.getAllResponseDTO();
    }

    @PostMapping("/sendmail")
    public void sendMail() {
        emailService.sendMail();
        System.out.println("Success in send email");
    }
//    @Transactionnal lienen quan hai bang

    @GetMapping(value = "/insertALlemployee")
    public ResponseEntity<?> getAndSaveListUser() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://hrm-api.nccsoft.vn/api/services/app/Checkin/GetUserForCheckin";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<String> rs = Collections.singletonList(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        JsonNode resultNode = rootNode.get("result");
        List<User> employees = mapper.readValue(resultNode.toString(), new TypeReference<List<User>>(){});


        userService.saveUser(employees);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
