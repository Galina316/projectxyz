package com.libraryApp.project.service;

import com.libraryApp.project.dao.UserDAO;
import com.libraryApp.project.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO){this.userDAO=userDAO;}

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }
    @Transactional
    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
      userDAO.deleteById(id);
    }
}
