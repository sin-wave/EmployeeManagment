package com.pratik.employee.services.ServiceImpl;

import com.pratik.employee.exception.ManageException;
import com.pratik.employee.model.Employee;
import com.pratik.employee.repository.EmployeeRepository;
import com.pratik.employee.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    Environment environment;
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employee_id) {
        return employeeRepository.findById(employee_id).get();
    }

    @Override
    public Object deleteEmployeeById(Long employee_id) {
        employeeRepository.deleteById(employee_id);
        Employee checkEmployee =null;
        Optional<Employee>exitemployee = employeeRepository.findById(employee_id);
        if (exitemployee.isPresent()){
            checkEmployee = exitemployee.get();
            employeeRepository.deleteById(checkEmployee.getEmployee_id());
        }
        else{
            throw new ManageException("SERVICE.employee_not_found");
        }

        return checkEmployee;

    }

    @Override
    public Employee updateEmployeeById(long employee_id, Employee employee) {
        Employee upEmp = null;
        Optional<Employee>fndusr=employeeRepository.findById(employee_id);
        if (fndusr.isPresent()){
            Employee upemp = fndusr.get();
            upemp.setSalary(employee.getSalary());
            upemp.setPhoneNumber(employee.getPhoneNumber());
            upemp.setEmailId(employee.getEmailId());
            upEmp = employeeRepository.save(upemp);

        }
        else {
            throw new ManageException("SERVICE.EMPLOYEE");
//            throw new ManageException("SERVICE.EMPLOYEE_NOT_FOUND");
        }

        return upEmp;


    }


}
