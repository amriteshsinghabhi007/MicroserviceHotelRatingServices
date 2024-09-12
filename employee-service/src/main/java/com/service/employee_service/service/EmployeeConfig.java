package com.service.employee_service.service;

import com.service.employee_service.dao.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class EmployeeConfig {
    @Bean
    public EmployeeService employeeService(){
       return new EmployeeService(new Employee());
    }
}
