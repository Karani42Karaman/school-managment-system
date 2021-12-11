package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.dto.LoginDto;
import com.karaman.schoolmanagmentsystem.model.ManagerModel;
import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.service.IManagerService;
import com.karaman.schoolmanagmentsystem.service.IStudentInfoService;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import com.karaman.schoolmanagmentsystem.service.ITeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {
    IManagerService managerService;
    IStudentsService studentsService;
    ITeachersService teachersService;
    IStudentInfoService studentInfoService;

    public ManagementController(IStudentInfoService studentInfoService, IManagerService managerService, IStudentsService studentsService, ITeachersService teachersService) {
        this.managerService = managerService;
        this.studentsService = studentsService;
        this.teachersService = teachersService;
        this.studentInfoService = studentInfoService;
    }

    @GetMapping(value = "/getManagemetPage")
    public String managementHomePage(Model model) {



        //tüm öğrenciler listesi dönecek
        // tüm derslerin listesi id ve name ile birlikde dönecek
        // tüm öğretmenlerin listesi id ve name ile birlikte dönecek
        List<StudentsModel> studentsModelList = studentsService.getAllStudents();
        model.addAttribute("studentsList", studentsModelList);
        return "managementShow";
    }





    @GetMapping(value = "/postStudentUpdate")
    public String editStudent(Model model, Long id) {
        StudentsModel studentsModel = studentsService.getStudentById(id);// bu id ye ait öğrenci geldi
        StudentInfoModel studentInfoModel = studentInfoService.getStudentInfoById(id);// bu id ye ait öğrenci bilgileri geldi
        model.addAttribute("studentsModel", studentsModel);
        return "editStudent";
    }

    @PostMapping(value = "/postStudentCreate")
    public String createStudent(StudentsModel studentsModel,HttpServletRequest request) {
        if(studentsModel==null){
            return "redirect:/management/getManagemetPage";
        }
        ManagerModel session = (ManagerModel)request.getSession().getAttribute("login");//Hangi müdür kayıt edecekse onun id si altına kayıt eder
        studentsModel.setManagerModel(session);
        Date date = new Date();
        studentsModel.setRecordTime(date);
        studentsService.saveStudent(studentsModel);
        return "redirect:/management/getManagemetPage";
    }

    @GetMapping("/postStudentDelete/{student_id}")
    public String deleteStudent(@PathVariable(value = "student_id") Long student_id) {
        if(student_id==null || student_id==0 ){
            return "redirect:/management/getManagemetPage";
        }
        studentsService.deleteStudentById(student_id);
        return "redirect:/management/getManagemetPage";
    }

}
