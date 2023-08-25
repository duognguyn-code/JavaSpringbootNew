package com.example.manageprojectemployeeretro.even;

import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListener implements ApplicationListener<UserCreatedEvent> {

    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        User user = event.getUser();

        System.out.println("User created: " + user.getFirstName());
    }
}
