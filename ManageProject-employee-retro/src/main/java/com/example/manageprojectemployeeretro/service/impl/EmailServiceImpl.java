package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dto.Mail;
import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class EmailServiceImpl  {

    private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=\"utf-8\"";

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String email;
    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    ThymeleafService thymeleafService;

    @Async
    public void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        Message message = new MimeMessage(session);
        try {
            String[] recipients = {
                    "duongntph16227@fpt.edu.vn",
                    "duong.nguyentung@ncc.asia",
                    "email2@example.com"
            };

            InternetAddress[] addresses = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                addresses[i] = new InternetAddress(recipients[i]);
            }

            message.setRecipients(Message.RecipientType.TO, addresses);

            message.setFrom(new InternetAddress(email));
            message.setSubject("Spring-email-with-thymeleaf subject");
            message.setContent(thymeleafService.getContent(), CONTENT_TYPE_TEXT_HTML);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
