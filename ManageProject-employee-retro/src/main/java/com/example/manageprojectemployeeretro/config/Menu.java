package com.example.manageprojectemployeeretro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "menu")
public class Menu {
    private String email;
    private String googleAnalyticsId;
    // Các getter và setter cho các thuộc tính

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoogleAnalyticsId() {
        return googleAnalyticsId;
    }

    public void setGoogleAnalyticsId(String googleAnalyticsId) {
        this.googleAnalyticsId = googleAnalyticsId;
    }
}
