package com.example.manageprojectemployeeretro.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LanguageController {
    private final MessageSource messageSource;

    @Autowired
    public LanguageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request) {
        String message = messageSource.getMessage("hello", null, "default message", request.getLocale());
        model.addAttribute("message", message);
        return "hello";
    }
}
