package com.libraryApp.project.dao;

import com.libraryApp.project.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    User saveUser(User user);
    void deleteById(int id);
}
