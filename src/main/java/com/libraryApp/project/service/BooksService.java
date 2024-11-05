package com.libraryApp.project.service;

import com.libraryApp.project.entity.Books;

import java.util.List;

public interface BooksService {
    List<Books> findAll();
    Books findById(int id);
    Books saveBook(Books books);
    void deleteById(int id);
}
