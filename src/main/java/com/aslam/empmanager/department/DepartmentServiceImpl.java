package com.aslam.empmanager.department;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aslam.empmanager.department.dto.DepartmentCreateRequest;
import com.aslam.empmanager.department.dto.DepartmentResponse;
import com.aslam.empmanager.department.dto.DepartmentUpdateRequest;
import com.aslam.empmanager.department.projections.DepartmentDetailView;
import com.aslam.empmanager.department.projections.DepartmentView;
import com.aslam.empmanager.employee.Employee;
import com.aslam.empmanager.employee.EmployeeRepository;
import com.aslam.empmanager.exceptions.InvalidOperationException;
import com.aslam.empmanager.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentMapper departmentMapper;

    @Transactional
    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        Department department;
        if (request.getDepartmentHeadId() != null) {
            Employee departmentHead = employeeRepository.findById(request.getDepartmentHeadId())
                    .orElseThrow(() -> new InvalidOperationException(
                            "Invalid department head id: " + request.getDepartmentHeadId()));

            department = new Department(
                    request.getName(),
                    request.getCreationDate(),
                    departmentHead);
        } else {
            department = new Department(
                    request.getName(),
                    request.getCreationDate());
        }

        departmentRepository.save(department);
        return departmentMapper.toResponse(department);
    }

    @Override
    @Transactional
    public DepartmentResponse getDepartmentById(UUID id, boolean expand) {
        if (expand) {
            DepartmentDetailView department = departmentRepository.getDepartmentDetailed(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

            return departmentMapper.toResponse(department);
        }

        DepartmentView department = departmentRepository.getDepartment(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        return departmentMapper.toResponse(department);
    }

    @Override
    public Page<DepartmentResponse> getAllDepartments(int page, int size) {
        Page<DepartmentView> departments = departmentRepository.getAllDepartments(PageRequest.of(page, size));

        return departments.map(departmentMapper::toResponse);
    }

    @Override
    @Transactional
    public DepartmentResponse updateDepartment(DepartmentUpdateRequest request) {
        Department department = departmentRepository.findById(request.getId())
                .orElseThrow(() -> new InvalidOperationException("Invalid department id: " + request.getId()));

        department.setName(request.getName());

        // Set Department Creation Date
        // Ensure it is not null
        department.setCreationDate(
                request.getCreationDate() == null ? department.getCreationDate() : request.getCreationDate());

        // Handle changing the department head
        if (request.getDepartmentHeadId() != null) {
            if (department.getDepartmentHead() == null
                    || !request.getDepartmentHeadId().equals(department.getDepartmentHead().getId())) {
                Employee departmentHead = employeeRepository.findById(request.getDepartmentHeadId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Employee not found with id: " + request.getDepartmentHeadId()));
                department.setDepartmentHead(departmentHead);
            }
        }

        departmentRepository.save(department);
        return departmentMapper.toResponse(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid department id: " + id));

        // Cannot delete department with employees
        if (!department.getEmployees().isEmpty()) {
            throw new InvalidOperationException("Cannot delete department with employees");
        }

        departmentRepository.delete(department);
    }

}
