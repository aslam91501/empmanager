package com.aslam.empmanager.employee;

import com.aslam.empmanager.employee.dto.EmployeeCreateRequest;
import com.aslam.empmanager.employee.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeCreateRequest request);
}
