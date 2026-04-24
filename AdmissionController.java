package com.school.controller;

import com.school.model.Student;
import com.school.service.StudentService;
import com.school.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdmissionController {

    @Autowired
    private StudentService service;

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Student student) {
        service.save(student);
        emailService.sendMail("New student: " + student.getStudentName());
        return "success";
    }
}