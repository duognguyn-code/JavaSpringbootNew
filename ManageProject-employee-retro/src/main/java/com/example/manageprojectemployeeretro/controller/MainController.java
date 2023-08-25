package com.example.manageprojectemployeeretro.controller;


import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value="/admin")
@CrossOrigin("*")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login/authen")
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
    @GetMapping
    public String welcomePage(){
        return "redirect:/admin/main.html";
    }
//    @GetMapping("/main.html")
//    public String welcomePageMain(){
//        return "admin/main";
//    }

}
