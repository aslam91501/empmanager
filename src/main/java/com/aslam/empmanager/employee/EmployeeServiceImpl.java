package com.aslam.empmanager.employee;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aslam.empmanager.department.Department;
import com.aslam.empmanager.department.DepartmentRepository;
import com.aslam.empmanager.employee.dto.EmployeeCreateRequest;
import com.aslam.empmanager.employee.dto.EmployeeResponse;
import com.aslam.empmanager.employee.dto.EmployeeUpdateRequest;
import com.aslam.empmanager.exceptions.InvalidOperationException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeCreateRequest request) {
        Address address = employeeMapper.toAddress(request.getAddress());

        Employee employee = new Employee(
                request.getName(),
                request.getDob(),
                request.getSalary(),
                address,
                request.getTitle(),
                request.getBonusPercentage());

        // Set join date if provided (in case it differs from current date)
        if (request.getJoinDate() != null)
            employee.setJoinDate(request.getJoinDate());

        // Get department
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(
                        () -> new InvalidOperationException("Invalid department id: " + request.getDepartmentId()));

        // assign department.
        employee.setDepartment(department);

        // Company head can't report to any manager
        if (request.getManagerId() == null && !request.isCompanyHead()) {
            throw new InvalidOperationException("Must have a reporting manager unless you are the company head");
        }

        if (request.isCompanyHead()) {
            // mark employee as company head
            employee.setCompanyHead(true);
        } else {
            // if employee isn't the company head, they must have a reporting manager
            Employee manager = employeeRepository.findById(request.getManagerId())
                    .orElseThrow(() -> new InvalidOperationException("Invalid manager id: " + request.getManagerId()));

            employee.setManager(manager);
        }

        employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    public Page<EmployeeResponse> getAllEmployees(int page, int size) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page, size));
        return employees.map(employeeMapper::toResponse);
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new InvalidOperationException("Invalid employee id: " + request.getId()));

        // update employee fields
        employee.setName(request.getName());
        employee.setDob(request.getDob());
        employee.setSalary(request.getSalary());
        employee.setAddress(employeeMapper.toAddress(request.getAddress()));
        employee.setTitle(request.getTitle());
        employee.setBonusPercentage(request.getBonusPercentage());

        // update reporting manager
        if (!request.getManagerId().equals(employee.getManager().getId())) {
            Employee manager = employeeRepository.findById(request.getManagerId())
                    .orElseThrow(() -> new InvalidOperationException("Invalid manager id: " + request.getManagerId()));

            employee.setManager(manager);
        }

        employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new InvalidOperationException("Invalid employee id: " + id));

        if (employee.isCompanyHead())
            throw new InvalidOperationException("Cannot delete company head");

        employeeRepository.delete(employee);
    }
}
