package com.aslam.empmanager.employee.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDepartmentChangeRequest {
    @NotNull(message = "Employee ID cannot be null")
    private UUID employeeId;

    @NotNull(message = "Department ID cannot be null")
    private UUID departmentId;
}
