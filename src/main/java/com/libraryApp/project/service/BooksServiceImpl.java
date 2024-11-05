package com.libraryApp.project.service;

import com.libraryApp.project.dao.BooksDAO;
import com.libraryApp.project.entity.Books;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BooksServiceImpl implements BooksService{
    BooksDAO booksDAO;
    @Autowired
    public BooksServiceImpl(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    public List<Books> findAll() {
        return booksDAO.findAll();
    }

    @Override
    public Books findById(int id) {
        return booksDAO.findById(id);
    }

    @Transactional
    @Override
    public Books saveBook(Books books) {
        return booksDAO.saveBook(books);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        booksDAO.deleteById(id);
    }


}
