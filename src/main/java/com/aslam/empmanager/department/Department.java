package com.aslam.empmanager.department;

import java.util.UUID;

import com.aslam.empmanager.employee.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Department {
    @Id
    private UUID id;
    private String name;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToOne
    private Employee departmentHead;

    public Department(String name, LocalDate creationDate, Employee departmentHead) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.creationDate = creationDate;
        this.departmentHead = departmentHead;

        this.employees = new ArrayList<>();
    }
}
