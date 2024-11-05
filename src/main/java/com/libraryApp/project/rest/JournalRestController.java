package com.libraryApp.project.rest;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Journal;
import com.libraryApp.project.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class JournalRestController {

    private JournalService journalService;
    @Autowired
    public JournalRestController(JournalService journalService){this.journalService=journalService;}

    @GetMapping("/journals")
//    public List<Journal> getJournals(){
//        return journalService.findAll();
    public String getJournals(Model model){
        List<Journal> list = journalService.findAll();
        model.addAttribute("journals",list);
        return "journals-list";
    }
    @GetMapping("/journals/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        System.out.println("Start ...");
        // create model attribute to bind form data
       Journal journal = new Journal();

        theModel.addAttribute("journals", journal);
        System.out.println("returning...");
        return "journals-form";
    }
    @GetMapping("/journals/{id}")
    public Journal getJournal(@PathVariable int id){
        if(journalService.findById(id)==null)
            throw new RuntimeException("No journal with this id "+id);
        return journalService.findById(id);
    }
    @PostMapping("/journal")
    //Request bean is translate to jason
    public Journal addJournal(@RequestBody Journal journal) {
       journal.setId(0);
        Journal journal1= journalService.saveJournal(journal);
        return journal1;
    }
    @DeleteMapping ("/journal/{id}")
    public ResponseEntity<String> deleteJournal(@PathVariable int id){
       Journal journal= journalService.findById(id);
        if(journal==null)return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No journal with id "+id) ;
        journalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Book deleted from table with id "+id);
    }



}
