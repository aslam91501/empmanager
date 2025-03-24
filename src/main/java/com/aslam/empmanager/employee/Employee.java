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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee {
    @Id
    private UUID id;

    @Setter
    private String name;

    @Setter
    private LocalDate dob;

    @Setter
    private float salary;

    @Setter
    private LocalDate joinDate;

    @Embedded
    @Setter
    private Address address;

    @Setter
    private String title;

    @Setter
    private float bonusPercentage;

    @ManyToOne
    @Setter
    private Employee manager;

    @ManyToOne
    @Setter
    private Department department;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;

    public Employee(String name, LocalDate dob, float salary, Address address, String title, float bonusPercentage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.title = title;
        this.bonusPercentage = bonusPercentage;

        this.subordinates = new ArrayList<>();
        this.joinDate = LocalDate.now();
    }
}
