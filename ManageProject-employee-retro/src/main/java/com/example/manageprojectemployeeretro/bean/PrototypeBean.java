package com.example.manageprojectemployeeretro.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private String message;

    public PrototypeBean() {
        this.message = "Hello, I am a prototype bean!";
    }

    public String getMessage() {
        return message;
    }
}
