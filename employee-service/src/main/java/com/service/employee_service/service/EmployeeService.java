package com.service.employee_service.service;

import com.service.employee_service.dao.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeService {
    Map<Integer,Employee> employeeId;
    public EmployeeService(Employee... employees){ //Employee... - multiple Arg
        this(Arrays.asList(employees));
    }
    public EmployeeService(List<Employee> employees){
        ConcurrentHashMap<Integer, Employee>  employeeIds = new ConcurrentHashMap<>();
        for (Employee employee : employees){
            employeeIds.put(employee.getId(),employee);
        }
        this.employeeId=employeeIds;
    }
    public void newEmployee(Employee employee){
        this.employeeId.put(employee.getId(),employee);

    }
    public Employee getEmployeeById(int id){
        return this.employeeId.get(id);
    }
}
