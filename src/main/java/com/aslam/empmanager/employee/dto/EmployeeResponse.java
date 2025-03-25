package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
    private UUID id;
    private String name;
    private LocalDate dob;
    private Float salary;
    private LocalDate joinDate;
    private String title;
    private Float bonusPercentage;

    private EmployeeResponse manager;
}
