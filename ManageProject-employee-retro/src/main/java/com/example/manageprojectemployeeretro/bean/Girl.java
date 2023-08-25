package com.example.manageprojectemployeeretro.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Girl {
    @PostConstruct
    public void postConstruct(){
        System.out.println("\t>> The Girl object after booting will run this program\n");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("\t>> Before being destroyed Girl object, run this function");
    }
}
