package com.karaman.schoolmanagmentsystem.controller;

import com.karaman.schoolmanagmentsystem.dto.InfoCreateDto;
import com.karaman.schoolmanagmentsystem.dto.StudentInfoDto;
import com.karaman.schoolmanagmentsystem.dto.TeacherCreateDto;
import com.karaman.schoolmanagmentsystem.dto.TeacherDto;
import com.karaman.schoolmanagmentsystem.model.*;
import com.karaman.schoolmanagmentsystem.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/management")
public class ManagementController {
    IManagerService managerService;
    IStudentsService studentsService;
    ITeachersService teachersService;
    IStudentInfoService studentInfoService;
    ILessonsService lessonsService;
    private static StudentsModel studentsModel;

    public ManagementController(ILessonsService lessonsService, IStudentInfoService studentInfoService, IManagerService managerService, IStudentsService studentsService, ITeachersService teachersService) {
        this.managerService = managerService;
        this.studentsService = studentsService;
        this.teachersService = teachersService;
        this.studentInfoService = studentInfoService;
        this.lessonsService = lessonsService;
    }

    @GetMapping(value = "/getManagemetPage")
    public String managementHomePage(Model model) {
        List<StudentsModel> studentsModelList = studentsService.getAllStudents();
        studentsModelList = studentsService.getAllStudents();
        model.addAttribute("studentsList", studentsModelList);
        return "managementStudentCreate";
    }

    @GetMapping(value = "/getStudentUpdate/{student_id}")
    public String getStudentUpdate(Model model, @PathVariable(value = "student_id") Long student_id) {
        if (student_id == null || student_id == 0) {
            return "redirect:/management/getManagemetPage";
        }
        StudentsModel studentsModel = studentsService.getStudentById(student_id);// bu id ye ait öğrenci geldi
        model.addAttribute("studentsModel", studentsModel);
        return "managementStudentUpdate";
    }

    @PostMapping(value = "/postStudentUpdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String postStudentUpdate(@Valid @ModelAttribute("studentsModel") StudentsModel studentsModel, BindingResult bindingResult, HttpServletRequest request) {
        String errorDate = (String) bindingResult.getFieldError("recordTime").getRejectedValue();
        if (studentsModel == null) {
            return "redirect:/management/getManagemetPage";
        }
        studentsModel.setManagerModel((ManagerModel) request.getSession().getAttribute("login"));
        studentsService.updateStudent(studentsModel);
        return "redirect:/management/getManagemetPage";
    }

    @PostMapping(value = "/postStudentCreate")
    public String createStudent(StudentsModel studentsModel, HttpServletRequest request) {
        if (studentsModel == null) {
            return "redirect:/management/getManagemetPage";
        }
        ManagerModel session = (ManagerModel) request.getSession().getAttribute("login");//Hangi müdür kayıt edecekse onun id si altına kayıt eder
        studentsModel.setManagerModel(session);
        studentsModel.setRecordTime(java.sql.Date.valueOf(LocalDate.now()));
        studentsService.saveStudent(studentsModel);
        return "redirect:/management/getManagemetPage";
    }

    @GetMapping("/postStudentDelete/{student_id}")
    public String deleteStudent(@PathVariable(value = "student_id") Long student_id) {
        if (student_id == null || student_id == 0) {
            return "redirect:/management/getManagemetPage";
        }
        studentsService.deleteStudentById(student_id);
        return "redirect:/management/getManagemetPage";
    }

    @GetMapping("/getStudentInfoCreate/{student_id}")
    public String getStudentInfo(Model model, @PathVariable(value = "student_id") Long student_id) {
        if (student_id == null || student_id == 0) {
            return "redirect:/management/getManagemetPage";
        }
        StudentInfoModel studentInfoModel = new StudentInfoModel();
        studentsModel = studentsService.getStudentById(student_id);
        StudentInfoDto studentInfoDto = new StudentInfoDto();

        studentInfoDto.teacherList = teachersService.getAllTeachers();
        studentInfoDto.studentInfoList = studentInfoService.getStudentInfoByStudentId(student_id);

        model.addAttribute("studentInfoDto", studentInfoDto);
        return "managementStudentCreateInfo";
    }

    @PostMapping("/postStudentInfoCreate")
    public String postInfoCreate(@Valid @ModelAttribute("infoCreateDto") InfoCreateDto infoCreateDto, HttpServletRequest request) {
        if (infoCreateDto == null) {
            return "redirect:/management/getStudentInfoCreate/" + studentsModel.getStudentId();
        }
        StudentInfoModel studentInfoModel = new StudentInfoModel();

        studentInfoModel.setLectureNoteOne(infoCreateDto.getLectureNoteOne());
        studentInfoModel.setLectureNoteTwo(infoCreateDto.getLectureNoteTwo());
        studentInfoModel.setLectureNoteThree(infoCreateDto.getLectureNoteThree());
        studentInfoModel.setRightOfAbsence(infoCreateDto.getRightOfAbsence());
        studentInfoModel.setTeacherId(infoCreateDto.getTeacherId());

        TeachersModel teachersModel = teachersService.getTeacherById(Long.valueOf(infoCreateDto.getTeacherId()));
        LessonsModel lessonsModel = lessonsService.getLessonById(Long.valueOf(teachersModel.getLessonsModel().getLessonId()));

        studentInfoModel.setLessonName(lessonsModel.getLessonName());
        studentInfoModel.setStudentsModel(studentsModel);
        studentInfoService.saveStudentInfo(studentInfoModel);
        return "redirect:/management/getStudentInfoCreate/" + studentsModel.getStudentId();
    }

    @GetMapping("/getStudentInfoDelete/{studentInfoId}")
    public String getStudentInfoDelete(@PathVariable(value = "studentInfoId") Long studentInfoId) {
        if (studentInfoId == null || studentInfoId == 0) {
            return "redirect:/management/getStudentInfoCreate/" + studentsModel.getStudentId();
        }
        studentInfoService.deleteStudentInfoById(studentInfoId);
        return "redirect:/management/getStudentInfoCreate/" + studentsModel.getStudentId();
    }

    @GetMapping(value = "/getTeacherPage")
    public String getTeacherPage(Model model, HttpServletRequest request) {
        TeacherDto teacherList = new TeacherDto();
        teacherList.teachersModels = teachersService.getAllTeachers();
        teacherList.lessonsModels = lessonsService.getAllLessonss();
        model.addAttribute("teacherList", teacherList);
        return "managementTeacherCreate";
    }

    @GetMapping("/getTeacherDelete/{teacher_id}")
    public String getDeleteTeacher(@PathVariable("teacher_id") Long teacher_id) {
        teachersService.deleteTeacherById(teacher_id);
        return "redirect:/management/getTeacherPage";
    }

    @PostMapping(value = "/postTeacherCreate")
    public String postTeacherCreate(@Valid @ModelAttribute("teachersDtoModel") TeacherCreateDto teachersDtoModel, BindingResult bindingResult, HttpServletRequest request) {
        if (teachersDtoModel == null) {
            return "redirect:/management/getTeacherPage";
        }

        TeachersModel teachersModel = new TeachersModel();

        teachersModel.setName(teachersDtoModel.getName());
        teachersModel.setSurName(teachersDtoModel.getSurName());
        teachersModel.setPassword(teachersDtoModel.getPassword());
        teachersModel.setTcNumber(teachersDtoModel.getTcNumber());
        teachersModel.setMail(teachersDtoModel.getMail());
        teachersModel.setPhoneNumber(teachersDtoModel.getPhoneNumber());
        teachersModel.setRecordTime(java.sql.Date.valueOf(LocalDate.now()));
        teachersModel.setGender(teachersDtoModel.isGender());

        ManagerModel session = (ManagerModel) request.getSession().getAttribute("login");
        teachersModel.setManagerModel(session);

        teachersModel.setLessonsModel(lessonsService.getLessonById(Long.valueOf(teachersDtoModel.getLessonId())));
        teachersService.saveTeacher(teachersModel);
        return "redirect:/management/getTeacherPage";
    }

}
