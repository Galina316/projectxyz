package com.libraryApp.project.rest;

import com.libraryApp.project.entity.Employees;
import com.libraryApp.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model theModel) {
        List<Employees> theEmployees= employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/employee/{id}")
    public Employees getEmployee(@PathVariable int id) {
        if (employeeService.findById(id) == null)
            throw new RuntimeException("No employee with this Id" + id);

        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employees> addEmployee(@PathVariable Employees employees) {
        employees.setId(0);
        Employees employees1 = employeeService.saveEmployee(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body(employees1);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        Employees employees = employeeService.findById(id);
        if (employees == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employee with is" + id);

        } else {
            employeeService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Employee been removed" + id);
        }
    }
}
