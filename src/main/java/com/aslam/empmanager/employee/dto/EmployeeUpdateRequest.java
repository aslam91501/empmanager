package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeUpdateRequest {
    @NotNull
    private UUID id;
    private String name;
    private LocalDate dob;
    private float salary;
    private AddressDto address;
    private String title;
    private float bonusPercentage;
    private UUID managerId;
}
