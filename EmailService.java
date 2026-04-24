package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("yourgmail@gmail.com");
        message.setSubject("New Admission Form");
        message.setText(content);
        mailSender.send(message);
    }
}