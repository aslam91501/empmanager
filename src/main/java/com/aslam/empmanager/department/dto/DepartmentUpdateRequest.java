package com.aslam.empmanager.department.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentUpdateRequest {
    @NotNull(message = "id cannot be null")
    private UUID id;

    @NotBlank(message = "name cannot be blank")
    private String name;
    private LocalDate creationDate;
    private UUID departmentHeadId;
}
