package com.example.RandomDemo.Models;

import com.example.RandomDemo.Config.ConstantService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = ConstantService.PROJECT_NAME_VALIDATION)
    @Size(min = 2, message = ConstantService.NAME_SIZE_VALIDATION)
    private String projectName;

    private String projectDetails;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;

    public Project() {
    }

    public Project(Long id, String projectName, String projectDetails, Employee employee) {
        Id = id;
        this.projectName = projectName;
        this.projectDetails = projectDetails;
        this.employee = employee;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
