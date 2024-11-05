package com.libraryApp.project.dao;

import com.libraryApp.project.entity.Books;
import com.libraryApp.project.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public List<Employees> findAll() {
        TypedQuery<Employees> theQuery = entityManager.createQuery("from Employees",Employees.class);
        return theQuery.getResultList();
    }

    @Override
    public Employees findById(int id) {

        return entityManager.find(Employees.class,id);
    }

    @Override
    public Employees saveEmployee(Employees employees) {
      return  entityManager.merge(employees);
    }

    @Override
    public void deleteById(int id) {
        Employees employees= entityManager.find(Employees.class,id);
        entityManager.remove(employees);
    }
}
