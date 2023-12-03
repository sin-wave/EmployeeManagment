package com.pratik.employee.controller;

import com.pratik.employee.model.Employee;
import com.pratik.employee.services.EmployeeServices;
//import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
//This is used to refresh the data at right time
@RestController
//http:-a class is mapped with http url--make a class as controller that handle http request
@RequestMapping("/employee")
//map url pattern to a method or class
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.createEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>>getAllEmployee() {
        return new ResponseEntity<List<Employee>>(employeeServices.getAllEmployee(), HttpStatus.OK);


    }
    @GetMapping("/{employee_id}")

    public ResponseEntity<Employee>getEmployeeById(@PathVariable long employee_id){
        return new ResponseEntity<>(employeeServices.getEmployeeById(employee_id),HttpStatus.OK);

        }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Object>deleteEmployeeById(@PathVariable long employee_id){
//        employeeServices.deleteEmployeeById(employee_id);
//        return new ResponseEntity<>("Employee Deleted Successful",
//                HttpStatus.GONE);
        return new ResponseEntity<>(employeeServices.deleteEmployeeById(employee_id),HttpStatus.GONE);

    }
    @PutMapping("/{employee_id}")
    public ResponseEntity<Employee>upemp(@PathVariable long employee_id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.updateEmployeeById(employee_id,employee),HttpStatus.OK);
    }
}
