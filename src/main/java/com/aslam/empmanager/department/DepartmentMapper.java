package com.aslam.empmanager.department;

import org.mapstruct.Mapper;

import com.aslam.empmanager.department.dto.DepartmentResponse;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentResponse toResponse(Department department);
}
