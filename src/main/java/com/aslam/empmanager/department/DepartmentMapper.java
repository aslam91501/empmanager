package com.aslam.empmanager.department;

import org.mapstruct.Mapper;

import com.aslam.empmanager.department.dto.DepartmentResponse;
import com.aslam.empmanager.department.projections.DepartmentDetailView;
import com.aslam.empmanager.department.projections.DepartmentView;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponse toResponse(Department department);

    DepartmentResponse toResponse(DepartmentView view);

    DepartmentResponse toResponse(DepartmentDetailView department);
}
