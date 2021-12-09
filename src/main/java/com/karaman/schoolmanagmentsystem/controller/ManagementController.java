package com.karaman.schoolmanagmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {


    @GetMapping(value = "/getManagemetPage")
    public String managementHomePage() {
        return "managementShow";
    }






}
