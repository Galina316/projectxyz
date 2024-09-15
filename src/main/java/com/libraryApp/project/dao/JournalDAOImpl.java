package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Journal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JournalDAOImpl implements JournalDAO {
    private EntityManager entityManager;
    @Autowired
    public JournalDAOImpl (EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public List<Journal> findAll() {
        TypedQuery<Journal> typedQuery = entityManager.createQuery("from Journal", Journal.class);
        List<Journal> journal = typedQuery.getResultList();
        return journal;
    }

    @Override
    public Journal findById(int id) {
        return entityManager.find(Journal.class,id);
    }

    @Override
    public Journal saveJournal(Journal journal) {
        return entityManager.merge(journal);
    }

    @Override
    public void delete(int id) {
        Journal journal = entityManager.find(Journal.class,id);

    }
}
