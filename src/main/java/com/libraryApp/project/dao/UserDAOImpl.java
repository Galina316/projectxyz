package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;
    @Autowired
    public UserDAOImpl(EntityManager entityManager){this.entityManager=entityManager;}


    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User",User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User saveUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteById(int id) {
     User user = entityManager.find(User.class,id);
     entityManager.remove(user);
    }
}
