package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import com.karaman.schoolmanagmentsystem.service.IStudentInfoService;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import com.karaman.schoolmanagmentsystem.service.ITeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    IStudentInfoService studentInfoService;
    ITeachersService teachersService;
    IStudentsService studentsService;
    public TeacherController(IStudentInfoService studentInfoService,IStudentsService studentsService,ITeachersService teachersService) {
        this.teachersService = teachersService;
        this.studentsService = studentsService;
        this.studentInfoService=studentInfoService;
    }


    @GetMapping(value = "/getTeacherPage")
    public String getTeacherPage(Model model) {
        List<StudentInfoModel> studentInfoList = studentInfoService.getAllStudentInfo();
        Map<Integer, List<StudentInfoModel>> groupStudents = studentInfoList.stream().collect(Collectors.groupingBy(w -> w.getTeacherId()));

        List<StudentInfoModel> list;
        for (StudentInfoModel student : studentInfoList) {
            if(groupStudents.containsKey(8)){
                list = groupStudents.get(8);
            }
        }

        return "teacherShow";
    }

}
