package com.libraryApp.project;

import com.libraryApp.project.dao.BooksDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
//private void createBook(BooksDAO booksDAO){
//	System.out.println("Creating new books....");
//	Book newBook = new Book();
//	Book newBook1 = new Book(1,"Melania","melania Trump",255,5);
//}
}
