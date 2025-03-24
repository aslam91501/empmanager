package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class EmployeeResponse {
    private UUID id;
    private String name;
    private LocalDate dob;
    private float salary;
    private LocalDate joinDate;
    private String title;
    private float bonusPercentage;

    private EmployeeResponse manager;
}
