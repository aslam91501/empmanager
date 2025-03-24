package com.aslam.empmanager.department.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.aslam.empmanager.employee.dto.EmployeeResponse;

import lombok.Data;

@Data
public class DepartmentResponse {
    private UUID id;
    private String name;
    private LocalDate creationDate;
    private EmployeeResponse departmentHead;
    private List<EmployeeResponse> employees;
}
