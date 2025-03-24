package com.aslam.empmanager.department;

import java.util.UUID;

import com.aslam.empmanager.employee.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Department {
    @Id
    private UUID id;

    @Setter
    private String name;

    @Setter
    private LocalDate creationDate;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToOne(cascade = CascadeType.ALL)
    @Setter
    private Employee departmentHead;

    public Department(String name, LocalDate creationDate, Employee departmentHead) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.departmentHead = departmentHead;

        this.creationDate = verifyCreationDate(creationDate);

        this.employees = new ArrayList<>();
    }

    public Department(String name, LocalDate creationDate) {
        this.id = UUID.randomUUID();
        this.name = name;

        this.creationDate = verifyCreationDate(creationDate);

        this.employees = new ArrayList<>();
    }

    private LocalDate verifyCreationDate(LocalDate creationDate) {
        if (creationDate != null) {
            return creationDate;
        } else {
            return LocalDate.now();
        }
    }
}
