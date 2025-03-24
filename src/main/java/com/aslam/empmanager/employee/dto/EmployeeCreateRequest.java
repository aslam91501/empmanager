package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeCreateRequest {
    @NotBlank
    private String name;

    @NotNull
    private LocalDate dob;

    private LocalDate joinDate;

    @NotNull
    private float salary;

    @NotBlank
    private String title;

    @NotNull
    private float bonusPercentage;

    @NotNull
    private AddressDto address;

    private UUID departmentId;
}