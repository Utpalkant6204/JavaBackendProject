package com.example.RandomDemo.DTO;

import com.example.RandomDemo.Config.ConstantService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectDTO {

    @NotNull(message = ConstantService.PROJECT_NAME_VALIDATION)
    @Size(min = 2, message = ConstantService.NAME_SIZE_VALIDATION)
    private String projectName;
    private String projectDetails;

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
}
