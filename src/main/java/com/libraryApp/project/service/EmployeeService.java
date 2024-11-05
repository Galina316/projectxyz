package com.libraryApp.project.service;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees findById(int id);
    Employees saveEmployee(Employees employees);
    void deleteById(int id);
}
