package com.aslam.empmanager.employee;

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

        if (request.getDepartmentId() != null) {
            Department department = departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(
                            () -> new InvalidOperationException("Invalid department id: " + request.getDepartmentId()));

            employee.setDepartment(department);

            if (department.getDepartmentHead() != null)
                employee.setManager(department.getDepartmentHead());
        }

        if (request.getJoinDate() != null)
            employee.setJoinDate(request.getJoinDate());

        employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    public Page<EmployeeResponse> getAllEmployees(int page, int size) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page, size));
        return employees.map(employeeMapper::toResponse);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new InvalidOperationException("Invalid employee id: " + request.getId()));

        if (request.getName() != null)
            employee.setName(request.getName());
        if (request.getDob() != null)
            employee.setDob(request.getDob());
        if (request.getSalary() != 0)
            employee.setSalary(request.getSalary());
        if (request.getAddress() != null)
            employee.setAddress(employeeMapper.toAddress(request.getAddress()));
        if (request.getTitle() != null)
            employee.setTitle(request.getTitle());
        if (request.getBonusPercentage() != 0)
            employee.setBonusPercentage(request.getBonusPercentage());

        if (request.getManagerId() != null) {
            Employee manager = employeeRepository.findById(request.getManagerId())
                    .orElseThrow(() -> new InvalidOperationException("Invalid manager id: " + request.getManagerId()));
            employee.setManager(manager);
        }

        employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

}
