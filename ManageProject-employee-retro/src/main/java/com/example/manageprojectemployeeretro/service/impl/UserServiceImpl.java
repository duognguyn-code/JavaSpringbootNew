package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.config.ERole;
import com.example.manageprojectemployeeretro.dao.ProjectRepository;
import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.dto.UserRequest;
import com.example.manageprojectemployeeretro.entity.Author;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.entity.Project;

import com.example.manageprojectemployeeretro.even.UserCreatedEvent;
import com.example.manageprojectemployeeretro.mapper.UserMapper;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ApplicationEventPublisher eventPublisher;
    private final UserRepository userDAO;
    private final ProjectRepository projectRepository;
    private final UserMapper userMapper;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    @Override
    @Cacheable
    public List<User> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    public String getAllUserWithLastName() {
        List<User> user = userDAO.getAllUser();
//        System.out.println(user.get(0).getRole().getName());
//        System.out.println(user.get(0).getProjects().getName());
        return "OK";
    }


    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void createUser(User user) {
        try {
            userDAO.save(user);
            UserCreatedEvent userCreatedEvent = new UserCreatedEvent(this, user);
            eventPublisher.publishEvent(userCreatedEvent);
            throw new RuntimeException("Error occurred");
        } catch (Exception e) {
            // Xử lý lỗi và ghi log
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    @Override
    @Cacheable("user")
    public User findUserById(int id) {
        simulateSlowService();
        return userDAO.findUserById(id);
    }
//    cache lưu trong memory
    @CacheEvict("user")
    public void clearCacheById(int id) {
    }
//     là mỗi lần  gọi hàm này nó sẽ xóa dữ liệu với id tương ứng ở trong cache user
    @CacheEvict(value = "user", allEntries = true)
    public void clearCache() {
    }
    //     là mỗi lần  gọi hàm này nó sẽ xóa dữ liệu  ở trong cache user
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
    @CachePut(value = "user")
    public User reloadAndFindUserById(int id) {
        simulateSlowService();
        return new User(id);
    }
    @Override
    public void deleteUserById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public User updateUser(User user) {
        try {
            return userDAO.save(user);
        } catch (Exception e) {
            // Xử lý khi transaction bị rollback in ra thông báo lỗi
            System.out.println("Transaction rolled back: " + e.getMessage());
            // Hoặc ném một ngoại lệ khác để báo hiệu rằng transaction đã bị rollback
            throw new RuntimeException("Transaction rolled back: " + e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAllResponseDTO() {
        List<User> users = userDAO.findAll(); // Thay thế bằng cách lấy danh sách người dùng từ nguồn dữ liệu của bạn
        return users.stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(List<User> users) {
        userDAO.saveAll(users);
    }


    @Override
    public User getUserByUserName(String username) {
        return userDAO.findUserByUsername(username);
    }



    @Override
    public List<User> getUsersByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID: " + projectId));
        return userDAO.findByProjects(project);
    }

    @Override
    public void insertUser(String firstName, String lastName, String password, String phone, Long roleId, Long projectId) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setPhone(phone);

        // Set project
        Project project = new Project();
        project.setId(projectId);
        user.setProjects(project);

        userDAO.save(user);

    }

//

    @Override
    public User getDataUserAndRole() {
        return null;
    };


}
