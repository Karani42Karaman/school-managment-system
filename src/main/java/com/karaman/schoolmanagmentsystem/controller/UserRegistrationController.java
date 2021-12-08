package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private IStudentsService userService;

    public UserRegistrationController(IStudentsService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(Model model, @ModelAttribute StudentsModel registrationDto) {
        model.addAttribute("user", registrationDto);
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") StudentsModel registrationDto) {
        Date date = new Date();
        registrationDto.setRecordTime(date);
        userService.saveStudent(registrationDto);
        return "redirect:/registration?success";
    }
}
