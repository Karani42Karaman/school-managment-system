package com.karaman.schoolmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
