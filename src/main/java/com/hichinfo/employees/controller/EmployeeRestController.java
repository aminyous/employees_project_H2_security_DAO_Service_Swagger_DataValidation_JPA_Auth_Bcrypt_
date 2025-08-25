package com.hichinfo.employees.controller;

import com.hichinfo.employees.entity.Employee;
import com.hichinfo.employees.request.EmployeeRequest;
import com.hichinfo.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest API Endpoints", description = "Operations related to employees.")
public class EmployeeRestController {


    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @Operation(summary = "Fetch single employee", description = "Get a single employee from database.")
    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId){
        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee to the DB.")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.save(employeeRequest);
        return employee;
    }

    @Operation(summary = "Update an employee", description = "Update the details of a current employee.")
    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId,
                                   @Valid  @RequestBody EmployeeRequest employeeRequest){
        return employeeService.update(employeeId, employeeRequest);
    }


    @Operation(summary = "Delete an employee", description = "Remove an employee from the DB.")
    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId){
        employeeService.deleteById(employeeId);
    }
}
