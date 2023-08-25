package com.example.manageprojectemployeeretro.service.impl;


import com.example.manageprojectemployeeretro.config.ERole;
import com.example.manageprojectemployeeretro.dao.AuthorRepository;
import com.example.manageprojectemployeeretro.dao.ProjectRepository;
import com.example.manageprojectemployeeretro.dao.RoleRepository;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.dto.LoginRequest;
import com.example.manageprojectemployeeretro.dto.SignUpRequest;
import com.example.manageprojectemployeeretro.entity.Author;
import com.example.manageprojectemployeeretro.entity.Role;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.jwt.JwtResponse;
import com.example.manageprojectemployeeretro.jwt.JwtTokenProvider;
import com.example.manageprojectemployeeretro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectRepository projectRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthorRepository authorRepository;


    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

            if(userRepository.existsUserByUsername(signUpRequest.getUserName())){
                return ResponseEntity
                        .badRequest()
                        .body("Error: Username is already taken!");
            }
            if (userRepository.existsUserByUsername(signUpRequest.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body("Error: Email is already in use!");
            }
            User user = new User();
            user.setUsername(signUpRequest.getUserName());
            user.setFirstName(signUpRequest.getFirstName());
            user.setLastName(signUpRequest.getLastName());
            user.setEmail(signUpRequest.getEmail());
            user.setPhone(signUpRequest.getPhone());
            user.setCode(signUpRequest.getCode());
            user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            user.setProjects(projectRepository.findProjectById(signUpRequest.getProjectId()));
            user = userRepository.save(user);
            Set<String> strRole = signUpRequest.getRole();
            Set<Role> roles = new HashSet<>();
            System.out.println(roleRepository.findAll());
            if(strRole == null){
                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("ErrorL: Role is not found "));
                roles.add(userRole);
            }else {
                strRole.forEach(role -> {
                    switch (role){
                        case "admin":
                            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: role is not found"));
                            roles.add(adminRole);
                            break;
                        default:
                            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException(("Error: role not found")));
                            roles.add(userRole);
                    }
                });
            }
            List<Author> authorList = new ArrayList<>();
            for (Role role: roles) {
                Author author = new Author();
                author.setUser(userRepository.getById(user.getId()));
                author.setRole(role);
                authorList.add(author);

            }
            user.setAuthorList(authorList);
            authorList = authorRepository.saveAll(authorList);
            System.out.println(user.getAuthorList());
            return ResponseEntity.ok("User registered successfully1");
    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        System.out.println(roles);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),userDetails.getEmail(),roles));
    }
}
