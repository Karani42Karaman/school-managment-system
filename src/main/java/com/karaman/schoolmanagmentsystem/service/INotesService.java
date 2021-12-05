package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.NotesModel;


import java.util.List;


public interface INotesService   {
    List<NotesModel> getAllNotes();
    NotesModel saveNote(NotesModel   notesModel);
    NotesModel getNoteById(Long id);
    NotesModel updateNote(NotesModel notesModel);
    void deleteNoteById(Long id);

}
