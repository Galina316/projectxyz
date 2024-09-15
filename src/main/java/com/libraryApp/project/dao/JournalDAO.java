package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Journal;

import java.util.List;

public interface JournalDAO {
    List<Journal> findAll();
    Journal findById(int id);
    Journal saveJournal(Journal journal);
    void delete (int id);
}
