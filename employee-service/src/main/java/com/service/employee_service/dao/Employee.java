package com.service.employee_service.dao;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Date dob;
    private int experience;
    private Date dateOfJoining;
}
