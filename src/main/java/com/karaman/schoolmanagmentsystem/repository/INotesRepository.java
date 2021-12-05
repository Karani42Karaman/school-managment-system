package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotesRepository extends JpaRepository<NotesModel,Long> {
}
