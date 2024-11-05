package com.libraryApp.project.rest;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BooksRestController {
    private BooksService booksService;

    @Autowired
    public BooksRestController(BooksService booksService){
        this.booksService=booksService;
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        List<Books> list = booksService.findAll();
        model.addAttribute("books",list);
        return "books-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        System.out.println("Start ...");
        // create model attribute to bind form data
       Books books = new Books();

        theModel.addAttribute("books", books);
        System.out.println("returning...");
        return "books-form";
    }

//    @GetMapping("/books/{id}")
//    public Books getBook(@PathVariable int id){
//        if(booksService.findById(id)==null)
//            throw new RuntimeException("No book with this id "+id);
//        booksService.findById(id);
//        return booksService.findById(id);


    public String getBook(Model model,@PathVariable int id){
        if(booksService.findById(id)==null)throw new RuntimeException("No book with this is"+id);
        List<Books>list = (List<Books>) booksService.findById(id);
        booksService.findById(id);
        return "books-list";
    }
    @PostMapping("/showFormForUpdate")
    //Request bean is translate to jason
    public ResponseEntity<Books> addBook (@RequestBody Books books) {
        books.setId(0);
        Books book = booksService.saveBook(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);

//    public String addBook(@RequestParam("bookId")int id,
//                          Model model){
//       Books books=booksService.findById(id);
//       model.addAttribute("books",Books.class);
//       return "books/books-list";
    }

    @DeleteMapping ("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        Books books = booksService.findById(id);
        if (books == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with id " + id);
        } else {
            booksService.deleteById(id);
        } return ResponseEntity.status(HttpStatus.OK).body("Book deleted with id "+id);

    }
}
