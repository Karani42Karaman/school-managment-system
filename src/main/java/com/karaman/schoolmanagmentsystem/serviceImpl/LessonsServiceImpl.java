package com.karaman.schoolmanagmentsystem.serviceImpl;


import com.karaman.schoolmanagmentsystem.model.LessonsModel;
import com.karaman.schoolmanagmentsystem.repository.ILessonsRepository;
import com.karaman.schoolmanagmentsystem.service.ILessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonsServiceImpl implements ILessonsService {
    @Autowired
    private ILessonsRepository lessonRepository;

    public LessonsServiceImpl(ILessonsRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<LessonsModel> getAllLessonss() {
        return lessonRepository.findAll();
    }

    @Override
    public LessonsModel saveLesson(LessonsModel lessonsModel) {
        return lessonRepository.save(lessonsModel);
    }

    @Override
    public LessonsModel getLessonById(Long id) {
        return lessonRepository.getById(id);
    }

    @Override
    public LessonsModel updateLesson(LessonsModel lessonsModel) {
        return lessonRepository.save(lessonsModel);
    }

    @Override
    public void deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
    }
}
