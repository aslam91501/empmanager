package com.aslam.empmanager.department;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aslam.empmanager.department.dto.DepartmentCreateRequest;
import com.aslam.empmanager.department.dto.DepartmentResponse;
import com.aslam.empmanager.department.dto.DepartmentUpdateRequest;
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
    public DepartmentResponse getDepartmentById(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return departmentMapper.toResponse(department);
    }

    @Override
    public Page<DepartmentResponse> getAllDepartments(int page, int size) {
        Page<Department> departments = departmentRepository.findAll(PageRequest.of(page, size));

        return departments.map(departmentMapper::toResponse);
    }

    @Override
    @Transactional
    public DepartmentResponse updateDepartment(DepartmentUpdateRequest request) {
        Department department = departmentRepository.findById(request.getId())
                .orElseThrow(() -> new InvalidOperationException("Invalid department id: " + request.getId()));

        if (request.getDepartmentHeadId() != null
                && !request.getDepartmentHeadId().equals(department.getDepartmentHead().getId())) {
            Employee departmentHead = employeeRepository.findById(request.getDepartmentHeadId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Employee not found with id: " + request.getDepartmentHeadId()));
            department.setDepartmentHead(departmentHead);
        }

        if (request.getName() != null)
            department.setName(request.getName());

        if (request.getCreationDate() != null)
            department.setCreationDate(request.getCreationDate());

        departmentRepository.save(department);
        return departmentMapper.toResponse(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid department id: " + id));

        if (!department.getEmployees().isEmpty()) {
            throw new InvalidOperationException("Cannot delete department with employees");
        }

        departmentRepository.delete(department);
    }
}
