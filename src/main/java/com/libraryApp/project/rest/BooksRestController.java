package com.libraryApp.project.rest;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksRestController {
    private BooksService booksService;

    @Autowired
    public BooksRestController(BooksService booksService){
        this.booksService=booksService;
    }

    @GetMapping("/books")
    public List<Books> getBooks(){return booksService.findAll();}

    @GetMapping("/books/{id}")
    public Books getBook(@PathVariable int id){
        if(booksService.findById(id)==null)
            throw new RuntimeException("No book with this id "+id);
        return booksService.findById(id);
    }
    @PostMapping("/book")
    //Request bean is translate to jason
    public Books addBook (@RequestBody Books employee) {
        employee.setId(0);
        Books book = booksService.saveBook(employee);
        return book;
    }

    @DeleteMapping ("/book/{id}")
    public String deleteBook(@PathVariable int id){
        Books books= booksService.findById(id);
        if(books==null)return "No book with id "+id;
       else booksService.delete(id);
        return "Book deleted from table with id "+id;
    }
}
