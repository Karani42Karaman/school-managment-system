package com.karaman.schoolmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @GetMapping(value = "/getTeacherPage")
    public String getTeacherPage() {
        return "student";
    }




}
