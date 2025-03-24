package com.aslam.empmanager.employee;

import org.springframework.data.domain.Page;

import com.aslam.empmanager.employee.dto.EmployeeCreateRequest;
import com.aslam.empmanager.employee.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeCreateRequest request);

    Page<EmployeeResponse> getAllEmployees(int page, int size);
}
