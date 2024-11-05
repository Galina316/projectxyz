package com.libraryApp.project.service;

import com.libraryApp.project.dao.EmployeeDAO;
import com.libraryApp.project.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO;
@Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employees> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employees findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employees saveEmployee(Employees employees) {
        return employeeDAO.saveEmployee(employees);
    }

    @Override
    public void deleteById(int id) {
employeeDAO.deleteById(id);
    }
}
