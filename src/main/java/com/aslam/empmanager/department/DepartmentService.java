package com.aslam.empmanager.department;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.aslam.empmanager.department.dto.DepartmentCreateRequest;
import com.aslam.empmanager.department.dto.DepartmentResponse;
import com.aslam.empmanager.department.dto.DepartmentUpdateRequest;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    DepartmentResponse getDepartmentById(UUID id, boolean expand);

    Page<DepartmentResponse> getAllDepartments(int page, int size);

    DepartmentResponse updateDepartment(DepartmentUpdateRequest request);

    void deleteDepartment(UUID id);
}
