package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class EmployeeCreateRequest {
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "dob cannot be null")
    private LocalDate dob;

    private LocalDate joinDate;

    @NotNull(message = "salary cannot be null")
    @Min(value = 5000, message = "salary must be greater than or equal to 5000")
    private float salary;

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotNull(message = "bonusPercentage cannot be null")
    @PositiveOrZero(message = "bonusPercentage must be greater than or equal to zero")
    private float bonusPercentage;

    @NotNull(message = "address cannot be null")
    private AddressDto address;

    @NotNull(message = "departmentId cannot be null")
    private UUID departmentId;

    private UUID managerId;

    private boolean isCompanyHead = false;
}