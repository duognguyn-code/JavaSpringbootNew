package com.example.manageprojectemployeeretro.controller;

//import com.example.manageprojectemployeeretro.utils.WebUtils;

import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String Login(){
        return "Login";
    }

    @PostMapping("/login")
    public String LoginAuthen(@RequestParam("email")String email,
                        @RequestParam("password") String password,Model model){
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null){
            return "redirect:/home";
        }else{
            model.addAttribute("ERROR", Constants.ERROR);
            return "redirect:/login";
        }

    }
    @GetMapping("/home")
    public String welcomePage(Model model){
        return "home";
    }

}
