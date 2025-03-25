package com.aslam.empmanager.department.projections;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.aslam.empmanager.employee.projections.EmployeeView;

public interface DepartmentDetailView {
    UUID getId();

    String getName();

    LocalDate getCreationDate();

    EmployeeView getDepartmentHead();

    List<EmployeeView> getEmployees();
}
