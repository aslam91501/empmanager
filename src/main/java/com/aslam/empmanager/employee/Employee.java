package com.aslam.empmanager.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.aslam.empmanager.department.Department;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee {
    @Id
    private UUID id;
    private String name;
    private LocalDate dob;
    private float salary;
    private LocalDate joinDate;

    @Embedded
    private Address address;
    private String title;
    private float bonusPercentage;

    @ManyToOne
    private Employee manager;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;

    public Employee(String name, LocalDate dob, float salary, Address address, String title, float bonusPercentage,
            LocalDate joinDate,
            Employee manager, Department department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.title = title;
        this.bonusPercentage = bonusPercentage;
        this.manager = manager;
        this.department = department;
        this.joinDate = joinDate;

        this.subordinates = new ArrayList<>();
    }
}
