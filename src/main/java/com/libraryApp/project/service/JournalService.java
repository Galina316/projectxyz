package com.libraryApp.project.service;


import com.libraryApp.project.entity.Journal;

import java.util.List;

public interface JournalService {
    List<Journal> findAll();
   Journal findById(int id);
   Journal saveJournal(Journal journal);
    void delete(int id);
}
