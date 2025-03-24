package com.aslam.empmanager.employee.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class EmployeeUpdateRequest {
    @NotNull(message = "id cannot be null")
    private UUID id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotNull(message = "dob cannot be null")
    private LocalDate dob;

    @NotNull(message = "salary cannot be null")
    private float salary;

    @NotNull(message = "address cannot be null")
    private AddressDto address;

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotNull(message = "bonusPercentage cannot be null")
    @PositiveOrZero(message = "bonusPercentage must be greater than or equal to zero")
    private float bonusPercentage;

    @NotNull(message = "managerId cannot be null")
    private UUID managerId;
}
