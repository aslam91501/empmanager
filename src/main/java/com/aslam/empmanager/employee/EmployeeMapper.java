package com.aslam.empmanager.employee;

import org.mapstruct.Mapper;

import com.aslam.empmanager.employee.dto.AddressDto;
import com.aslam.empmanager.employee.dto.EmployeeResponse;
import com.aslam.empmanager.employee.projections.EmployeeDetailView;
import com.aslam.empmanager.employee.projections.EmployeeLookupView;
import com.aslam.empmanager.employee.projections.EmployeeView;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponse toResponse(Employee employee);

    EmployeeResponse toResponse(EmployeeView employeeView);

    EmployeeResponse toResponse(EmployeeDetailView employee);

    EmployeeResponse toResponse(EmployeeLookupView employee);

    Address toAddress(AddressDto addressDto);
}
