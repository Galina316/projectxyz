package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Employees;

import java.util.List;

public interface EmployeeDAO {
    List<Employees> findAll();
   Employees findById(int id);
    Employees saveEmployee(Employees employees);
    void deleteById (int id);
}
