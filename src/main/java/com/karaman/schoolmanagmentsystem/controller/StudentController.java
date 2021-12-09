package com.karaman.schoolmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/getStudentPage")
    public String showStudent() {
        return "studentShow";
    }

}
