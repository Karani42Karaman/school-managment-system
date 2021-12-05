package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.LessonsModel;


import java.util.List;

public interface ILessonsService   {
    List<LessonsModel> getAllLessonss();
    LessonsModel saveLesson(LessonsModel lessonsModel);
    LessonsModel getLessonById(Long id);
    LessonsModel updateLesson(LessonsModel lessonsModel);
    void deleteLessonById(Long id);
}
