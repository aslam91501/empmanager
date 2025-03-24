package com.aslam.empmanager.employee;

import org.mapstruct.Mapper;

import com.aslam.empmanager.employee.dto.AddressDto;
import com.aslam.empmanager.employee.dto.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponse toResponse(Employee employee);

    Address toAddress(AddressDto addressDto);
}
