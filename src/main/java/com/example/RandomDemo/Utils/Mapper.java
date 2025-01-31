package com.example.RandomDemo.Utils;

import com.example.RandomDemo.Config.ConstantService;
import com.example.RandomDemo.DTO.AddressDTO;
import com.example.RandomDemo.DTO.EmployeeDTO;
import com.example.RandomDemo.DTO.ProjectDTO;
import com.example.RandomDemo.Models.Address;
import com.example.RandomDemo.Models.Employee;
import com.example.RandomDemo.Models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    @Autowired
    private DateTimeFormatterUtils dateTimeFormatterUtils;

    public Employee toEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setDateOfBirth(dateTimeFormatterUtils.formatDate(employeeDTO.getDateOfBirth()));

        // Map AddressDTO to Address
        if (employeeDTO.getAddress() != null) {
            Address address = new Address();
            address.setState(employeeDTO.getAddress().getState());
            address.setCity(employeeDTO.getAddress().getCity());
            address.setLocality(employeeDTO.getAddress().getLocality());
            address.setDistrict(employeeDTO.getAddress().getDistrict());
            address.setPincode(employeeDTO.getAddress().getPincode());
            employee.setAddress(address);
        }

        // Map ProjectDTO list to Project list
        if (employeeDTO.getProjects() != null) {
            List<Project> projects = employeeDTO.getProjects().stream()
                    .map(projectDTO -> {
                        Project project = new Project();
                        project.setProjectName(projectDTO.getProjectName());
                        project.setProjectDetails(projectDTO.getProjectDetails());
                        return project;
                    })
                    .toList();
            employee.setProjects(projects);
        }

        return employee;
    }

    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setDateOfBirth(dateTimeFormatterUtils.formatDatePattern(employee.getDateOfBirth(), ConstantService.DATE_FORMAT));

        // Map Address to AddressDTO
        if (employee.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setState(employee.getAddress().getState());
            addressDTO.setCity(employee.getAddress().getCity());
            addressDTO.setLocality(employee.getAddress().getLocality());
            addressDTO.setDistrict(employee.getAddress().getDistrict());
            addressDTO.setPincode(employee.getAddress().getPincode());
            employeeDTO.setAddress(addressDTO);
        }

        // Map Project list to ProjectDTO list
        if (employee.getProjects() != null) {
            List<ProjectDTO> projectDTOs = employee.getProjects().stream()
                    .map(project -> {
                        ProjectDTO projectDTO = new ProjectDTO();
                        projectDTO.setProjectName(project.getProjectName());
                        projectDTO.setProjectDetails(project.getProjectDetails());
                        return projectDTO;
                    })
                    .collect(Collectors.toList());
            employeeDTO.setProjects(projectDTOs);
        }

        return employeeDTO;
    }
}
