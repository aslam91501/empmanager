package com.aslam.empmanager.department.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.aslam.empmanager.employee.dto.EmployeeResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentResponse {
    private UUID id;
    private String name;
    private LocalDate creationDate;

    private EmployeeResponse departmentHead;

    private List<EmployeeResponse> employees;
}
