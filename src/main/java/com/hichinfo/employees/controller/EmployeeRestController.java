package com.hichinfo.employees.controller;

import com.hichinfo.employees.dao.EmployeeDAO;
import com.hichinfo.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {


    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
