package com.aslam.empmanager.department.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentCreateRequest {
    @NotBlank
    private String name;
    private LocalDate creationDate;
    private UUID departmentHeadId;
}
