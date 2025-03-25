package com.aslam.empmanager.department;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aslam.empmanager.department.projections.DepartmentDetailView;
import com.aslam.empmanager.department.projections.DepartmentView;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    @Query("SELECT d FROM Department d")
    Page<DepartmentView> getAllDepartments(PageRequest pageRequest);

    @Query("SELECT d FROM Department d WHERE d.id = :id")
    Optional<DepartmentDetailView> getDepartmentDetailed(UUID id);

    @Query("SELECT d FROM Department d WHERE d.id = :id")
    Optional<DepartmentView> getDepartment(UUID id);
}
