package com.aslam.empmanager.employee;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aslam.empmanager.employee.projections.EmployeeDetailView;
import com.aslam.empmanager.employee.projections.EmployeeLookupView;
import com.aslam.empmanager.employee.projections.EmployeeView;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Boolean existsByIsCompanyHeadTrue();

    @Query("SELECT e FROM Employee e")
    Page<EmployeeView> getAll(PageRequest pageRequest);

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<EmployeeDetailView> getEmployeeDetailed(UUID id);

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<EmployeeLookupView> employeeLookup(UUID id);
}
