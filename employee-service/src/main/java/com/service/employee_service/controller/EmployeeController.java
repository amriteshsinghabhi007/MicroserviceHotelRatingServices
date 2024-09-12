package com.service.employee_service.controller;

import com.service.employee_service.dao.Employee;
import com.service.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        this.employeeService.newEmployee(employee);
    }
    @GetMapping("/get")
    public Employee getEmployee(@RequestParam(name = "id") int id){

        return this.employeeService.getEmployeeById(id);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam(name = "id") int id , @RequestBody Employee employee){
        System.out.println("updated");
        return this.employeeService.updateEmployeeById(id,employee);
    }
    @DeleteMapping("/delete")
    public Employee deleteEmployee(@RequestParam(name = "id") int id,@RequestBody Employee employee){
        return this.employeeService.deleteEmployeeById(id,employee);
    }
}
