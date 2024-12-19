package com.example.demo.Interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class employeeController {
    @Autowired
    private  EmployeeServices employeeServices;
    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        this.
    }
    }
