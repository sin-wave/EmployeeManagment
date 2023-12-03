package com.pratik.employee.model;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

@Data

@Entity

@Table(name = "employee")


public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long employee_id;
    private String dataOfJoining;
    private long salary;
    private String emailId;
    private long phoneNumber;
    private String designation;
    private String password;
    private long age;


}