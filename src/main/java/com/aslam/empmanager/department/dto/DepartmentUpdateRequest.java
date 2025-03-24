package com.aslam.empmanager.department.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentUpdateRequest {
    @NotBlank(message = "id cannot be blank")
    private UUID id;

    @NotBlank(message = "name cannot be blank")
    private String name;
    private LocalDate creationDate;
    private UUID departmentHeadId;
}
