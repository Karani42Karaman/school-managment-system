package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRegistrationController {

    private IStudentsService userService;

    public UserRegistrationController(IStudentsService userService) {
        super();
        this.userService = userService;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model, @ModelAttribute StudentsModel registrationDto) {
        model.addAttribute("user", registrationDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") StudentsModel registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
