package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.service.IStudentInfoService;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {

    IStudentsService studentsService;
    IStudentInfoService studentInfoService;

    public StudentController(IStudentsService studentsService, IStudentInfoService studentInfoService) {
        this.studentsService = studentsService;
        this.studentInfoService = studentInfoService;
    }

    @GetMapping("/getStudentPage")
    public String showStudent(Model model, HttpServletRequest request) {
        StudentsModel studentSession = (StudentsModel) request.getSession().getAttribute("student");
        StudentsModel studentModel = studentsService.getStudentById(studentSession.getStudentId());
        model.addAttribute("student", studentModel);
        return "studentShow";
    }

    @GetMapping("/getStudentInfoPage/{student_id}")
    public String showStudentInfo(@PathVariable("student_id") Long student_id, Model model, HttpServletRequest request) {
        StudentsModel studentSession = (StudentsModel) request.getSession().getAttribute("student");
        if (student_id == studentSession.getStudentId()) {// bir nevi güvenlik kontrolü id değiştirip başka öğrencilerin bilgilerine bakılmasın
            StudentsModel studentModel = studentsService.getStudentById(studentSession.getStudentId());
            List<StudentInfoModel> studentInfoModelList = studentInfoService.getStudentInfoByStudentId(studentSession.getStudentId());
            model.addAttribute("studentInfoModelList", studentInfoModelList);
            return "studentInfoShow";
        }
        return "redirect:/student/getStudentPage";
    }
}
