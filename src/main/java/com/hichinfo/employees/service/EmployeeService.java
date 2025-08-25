package com.hichinfo.employees.service;

import com.hichinfo.employees.entity.Employee;
import com.hichinfo.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(long theId);
    Employee save(EmployeeRequest employeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);
    void deleteById(long theId);
}
