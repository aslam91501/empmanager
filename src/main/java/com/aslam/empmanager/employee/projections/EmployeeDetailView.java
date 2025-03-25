package com.aslam.empmanager.employee.projections;

import java.time.LocalDate;
import java.util.UUID;

import com.aslam.empmanager.department.projections.DepartmentView;
import com.aslam.empmanager.employee.Address;

public interface EmployeeDetailView {
    UUID getId();

    String getName();

    LocalDate getDob();

    float getSalary();

    LocalDate getJoinDate();

    Address getAddress();

    String getTitle();

    float getBonusPercentage();

    boolean isCompanyHead();

    EmployeeView getManager();

    DepartmentView getDepartment();
}
