package com.example.demo.Interview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class EmployeeServices {

    Map<Integer,Employee> employeeId;
    public EmployeeServices(Employee... employees){
        this(Arrays.asList(employees));
    }
    public void createEmployee(Employee employee){

    }
}
