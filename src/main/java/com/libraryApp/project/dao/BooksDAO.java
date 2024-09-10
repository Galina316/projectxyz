package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;

import java.util.List;

public interface BooksDAO {
    List<Books> findAll();
    Books findById(int id);
    Books saveBook(Books books);
}
