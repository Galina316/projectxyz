package com.libraryApp.project.rest;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Journal;
import com.libraryApp.project.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class JournalRestController {

    private JournalService journalService;
    @Autowired
    public JournalRestController(JournalService journalService){this.journalService=journalService;}

    @GetMapping("/journals")
    public List<Journal> getJournals(){
        return journalService.findAll();
    }
    @GetMapping("/journals/{id}")
    public Journal getJournal(@PathVariable int id){
        if(journalService.findById(id)==null)
            throw new RuntimeException("No journal with this id "+id);
        return journalService.findById(id);
    }
    @PostMapping("/journals")
    //Request bean is translate to jason
    public Journal addJournal(@RequestBody Journal journal) {
       journal.setId(0);
        Journal journal1= journalService.saveJournal(journal);
        return journal1;
    }
    @DeleteMapping ("/journals/{id}")
    public String deleteJournal(@PathVariable int id){
       Journal journal= journalService.findById(id);
        if(journal==null)return "No journal with id "+id;
        journalService.delete(id);
        return "Book deleted from table with id "+id;
    }



}
