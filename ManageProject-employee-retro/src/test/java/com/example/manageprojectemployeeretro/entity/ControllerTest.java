package com.example.manageprojectemployeeretro.entity;

import com.example.manageprojectemployeeretro.config.Config;
import com.example.manageprojectemployeeretro.config.TransactionConfig;
import com.example.manageprojectemployeeretro.controller.rest.UserRestController;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.RoleService;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    private UserRestController yourController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Config config;

    @Mock
    private TransactionConfig transactionConfig;

    @Mock
    private UserService userService;

    @Mock
    private RoleService roleService;

    @Mock
    private ProjectService projectService;

    @Mock
    private EmailServiceImpl emailService;

//    @org.junit.Test
//    public void testGetUserRoleName() {
//        // Tạo dữ liệu giả cho userRepository.findUserById()
//        User user = new User();
//        when(userRepository.findUserById(anyInt())).thenReturn(user);
//
//        // Gọi phương thức kiểm thử
//        String result = yourController.getUserRoleName(1);
//
//        // Kiểm tra kết quả
//        assertEquals("1", result);
//    }

    @Test
    public void testTestDataUseValue() {
        // Tạo dữ liệu giả cho config.Getdata()
        String data = "this is more message1 in beta";
        when(config.Getdata()).thenReturn(data);

        // Gọi phương thức kiểm thử
        ResponseEntity response = yourController.testDataUsevalue();

        // Kiểm tra kết quả
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(data, response.getBody());
    }

//    @Test
//    public void testTestUseEnvironment() {
//        // Tạo dữ liệu giả cho transactionConfig.getdata()
//        String data = "Test data";
//        when(transactionConfig.getdata()).thenReturn(data);
//
//        // Gọi phương thức kiểm thử
//        ResponseEntity response = yourController.testUseEnvironment();
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(data, response.getBody());
//    }

//    @org.junit.Test
//    public void testGetAllUserForLazyAndEager() {
//        // Tạo dữ liệu giả cho userService.getAllUserWithLastName()
//        List<User> users = Arrays.asList(
//                new User(),
//                new User()
//        );
//        when(userService.getAllUserWithLastName()).thenReturn(String.valueOf(users));
//
//        // Gọi phương thức kiểm thử
//        ResponseEntity response = yourController.getAllUserForLazyAndEager();
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(users, response.getBody());
//    }

    @org.junit.Test
    public void testGetAll() {
        // Tạo dữ liệu giả cho roleService.getAllRole()
        List<Role> roles = Arrays.asList(
                new Role(),
                new Role()
        );
        when(roleService.getAllRole()).thenReturn(roles);

        // Gọi phương thức kiểm thử
        ResponseEntity response = yourController.getAll();

        // Kiểm tra kết quả
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roles, response.getBody());
    }

    @Test
    public void testGetAllProject() {
        // Tạo dữ liệu giả cho projectService.getAllProJect()
        List<Project> projects = Arrays.asList(
                new Project(),
                new Project()
        );
        when(projectService.getAllProJect()).thenReturn(projects);

        // Gọi phương thức kiểm thử
        ResponseEntity response = yourController.getAllProject();

        // Kiểm tra kết quả
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projects, response.getBody());
    }

//    @org.junit.Test
//    public void testGetallUserwithUsername() {
//        // Tạo dữ liệu giả cho userService.getUserByUserName()
//        User user = new User("Anhlong");
//        when(userService.getUserByUserName(anyString())).thenReturn(user);
//
//        // Gọi phương thức kiểm thử
//        String result = yourController.getallUserwithUsername();
//
//        // Kiểm tra kết quả
//        assertEquals(1,result);
//    }

//    @Test
//    public void testGetProjectByName() {
//        // Tạo dữ liệu giả cho projectService.findProjectsByName()
//        List<ProjectProjection> projects = Arrays.asList(
//                new ProjectProjection("Project 1"),
//                new ProjectProjection("Project 2")
//        );
//        when(projectService.findProjectsByName(anyString())).thenReturn(projects);
//
//        // Gọi phương thức kiểm thử
//        ResponseEntity<List<ProjectProjection>> response = yourController.getProjectByName("Project 1");
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(projects, response.getBody());
//    }

//    @Test
//    public void testCreateUser() {
//        // Gọi phương thức kiểm thử
//        ResponseEntity<String> response = yourController.createUser(new User());
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("User created successfully", response.getBody());
//
//        // Kiểm tra xem userService.createUser() đã được gọi
//        verify(userService, times(1)).createUser(any(User.class));
//    }
//
//    @Test
//    public void testGetAllUsers() {
//        // Tạo dữ liệu giả cho userService.getAllUsers()
//        List<User> users = Arrays.asList(
//                new User(1),
//                new User(2)
//        );
//        Page<User> userPage = new PageImpl<>(users);
//        when(userService.getAllUsers(any(Pageable.class))).thenReturn(userPage);
//
//        // Gọi phương thức kiểm thử
//        ResponseEntity<Page<User>> response = yourController.getAllUsers(0);
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userPage, response.getBody());
//    }
//
//    @Test
//    public void testGetAllUsersWithRole() {
//        // Tạo dữ liệu giả cho userService.getDataUserAndRole()
//        User user = new User(1);
//        when(userService.getDataUserAndRole()).thenReturn(user);
//
//        // Gọi phương thức kiểm thử
//        ResponseEntity<User> response = yourController.getAllUsersWithRole();
//
//        // Kiểm tra kết quả
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(user, response.getBody());
//    }
//
//    @Test
//    public void testGetAllUsersResponseEntity() {
//        // Tạo dữ liệu giả cho userService.getAllResponseDTO()
//        List<UserDTO> userDTOs = Arrays.asList(
//                new UserDTO(),
//                new UserDTO()
//        );
//        when(userService.getAllResponseDTO()).thenReturn(userDTOs);
//
//        // Gọi phương thức kiểm thử
//        List<UserDTO> response = yourController.getAllUsersResponseENtity();
//
//        // Kiểm tra kết quả
//        assertEquals(userDTOs, response);
//    }

    @org.junit.Test
    public void testSendMail() {
        // Gọi phương thức kiểm thử
        yourController.sendMail();

        // Kiểm tra xem emailService.sendMail() đã được gọi
        verify(emailService, times(1)).sendMail();
    }
}