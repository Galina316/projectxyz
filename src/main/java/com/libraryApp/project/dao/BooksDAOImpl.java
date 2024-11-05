package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDAOImpl implements BooksDAO {
    private EntityManager entityManager;

    @Autowired
    public BooksDAOImpl (EntityManager entityManager){this.entityManager = entityManager;}


    @Override
    public List<Books> findAll() {
        TypedQuery<Books> theQuery = entityManager.createQuery("from Books",Books.class);
        List<Books> books = theQuery.getResultList();
        return books;
    }

    @Override
    public Books findById(int id) {
        Books books = entityManager.find(Books.class,id);
        return books;
    }

    @Override
    public Books saveBook(Books books) {
        return entityManager.merge(books);
    }

    @Override
    public void deleteById(int id) {
        Books books = entityManager.find(Books.class,id);
        entityManager.remove(books);
    }
}
