package com.aslam.empmanager.department;

import java.util.List;
import java.util.UUID;

import com.aslam.empmanager.department.dto.DepartmentCreateRequest;
import com.aslam.empmanager.department.dto.DepartmentResponse;
import com.aslam.empmanager.department.dto.DepartmentUpdateRequest;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    DepartmentResponse getDepartmentById(UUID id);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse updateDepartment(DepartmentUpdateRequest request);

    void deleteDepartment(UUID id);
}
