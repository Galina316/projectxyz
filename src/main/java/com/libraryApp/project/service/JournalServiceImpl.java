package com.libraryApp.project.service;

import com.libraryApp.project.dao.JournalDAO;
import com.libraryApp.project.entity.Journal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalServiceImpl implements  JournalService{
    JournalDAO journalDAO;
    @Autowired
    public JournalServiceImpl(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }


    @Override
    public List<Journal> findAll() {
        return journalDAO.findAll();
    }

    @Override
    public Journal findById(int id) {
        return journalDAO.findById(id);
    }
    @Transactional
    @Override
    public Journal saveJournal(Journal journal) {
        return journalDAO.saveJournal(journal);
    }
    @Transactional
    @Override
    public void delete(int id) {
        journalDAO.delete(id);

    }
}
