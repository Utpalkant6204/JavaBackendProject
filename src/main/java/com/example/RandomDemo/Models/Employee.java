package com.example.RandomDemo.Models;

import com.example.RandomDemo.Config.ConstantService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = ConstantService.NAME_VALIDATION)
    @Size(min = 2, message = ConstantService.NAME_SIZE_VALIDATION)
    private String name;

    private LocalDateTime dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @Valid
    private List<Project> projects = new ArrayList<>();


    public Employee() {
    }

    public Employee(Long id, String name, LocalDateTime dateOfBirth, Address address, List<Project> projects) {
        Id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.projects = projects;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
