package com.aslam.empmanager.department.projections;

import java.time.LocalDate;
import java.util.UUID;

import com.aslam.empmanager.employee.projections.EmployeeView;

public interface DepartmentView {
    UUID getId();

    String getName();

    LocalDate getCreationDate();

    EmployeeView getDepartmentHead();
}
