package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.dto.LoginDto;
import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    IStudentsService studentsService;

    public LoginController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }


    @GetMapping
    public String login(Model model,@ModelAttribute("login") LoginDto loginDto) {
        model.addAttribute("login",loginDto);
        return "login";
    }


    @PostMapping(value = "/postlogin")
    public String login(@ModelAttribute LoginDto loginDto) {

        if(loginDto.getRole().equals("student")){
            List<StudentsModel> studentList =  studentsService.getAllStudents();
            for (StudentsModel studentsModel : studentList) {
                if (studentsModel.getTcNumber().equals (loginDto.getTcNo()) && studentsModel.getPassword().equals(loginDto.getPassword())) {
                    return "teacher";
                }
            }
        }else{
        }
        return "redirect:/teacher/getTeacherPage";
    }

}
