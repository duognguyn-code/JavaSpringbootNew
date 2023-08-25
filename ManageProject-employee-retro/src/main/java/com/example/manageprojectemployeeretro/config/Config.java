package com.example.manageprojectemployeeretro.config;


import com.example.manageprojectemployeeretro.bean.Girl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Properties;

@Configuration
@EnableCaching
@PropertySources({
        @PropertySource("classpath:application-alpha.properties"),
        @PropertySource("classpath:application-beta.properties")
})
@ConfigurationProperties("bac")
public class Config {
    @Value("${message}")
    private String message;

    @Bean
    public Girl getiNit(){
        return  new Girl();
    }

    @Bean
    public String Getdata(){
        return message;
    }

//
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        DefaultUriBuilderFactory defaultUriBuilderFactory = new
                DefaultUriBuilderFactory("http://hrm-api.nccsoft.vn/api/services/app/Checkin/GetUserForCheckin");
        restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
        return restTemplate;
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public RandomStuff randomStuff() {
//        return new RandomStuff();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Person personPrototype() {
//        return new Person();
//    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("nguyentungduonglk1@gmail.com");
        mailSender.setPassword("iscdvtuyqsfpwmbp");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("products");
    }

}
