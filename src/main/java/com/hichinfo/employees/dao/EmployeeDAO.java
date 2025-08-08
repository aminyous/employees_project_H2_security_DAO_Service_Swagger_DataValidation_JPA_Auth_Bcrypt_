package com.hichinfo.employees.dao;

import com.hichinfo.employees.entity.Employee;


import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
