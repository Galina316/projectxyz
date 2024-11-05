package com.libraryApp.project.service;

import com.libraryApp.project.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User saveUser(User user);
    void deleteById(int id);
}
