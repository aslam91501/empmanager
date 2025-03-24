package com.aslam.empmanager.employee;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.aslam.empmanager.employee.dto.EmployeeCreateRequest;
import com.aslam.empmanager.employee.dto.EmployeeDepartmentChangeRequest;
import com.aslam.empmanager.employee.dto.EmployeeResponse;
import com.aslam.empmanager.employee.dto.EmployeeUpdateRequest;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeCreateRequest request);

    Page<EmployeeResponse> getAllEmployees(int page, int size);

    EmployeeResponse updateEmployee(EmployeeUpdateRequest request);

    EmployeeResponse changeEmployeeDepartment(EmployeeDepartmentChangeRequest request);

    void deleteEmployee(UUID id);
}
