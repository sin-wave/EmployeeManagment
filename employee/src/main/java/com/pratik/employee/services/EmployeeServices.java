package com.pratik.employee.services;
import com.pratik.employee.model.Employee;

import java.util.List;

public interface EmployeeServices {
    //Business Logic
// Abstract method to be implemented by implementing classes
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long employee_id);

    Object deleteEmployeeById(Long employee_id);
    Employee updateEmployeeById(long employee_id,Employee employee);


}
