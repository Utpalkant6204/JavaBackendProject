package com.example.RandomDemo.Services.Interface;

import com.example.RandomDemo.DTO.CriteriaDTO;
import com.example.RandomDemo.DTO.EmployeeDTO;
import org.springframework.http.HttpStatusCode;


public interface EmployeeService {
    public Object saveEmployee(EmployeeDTO employee);

    public Object searchEmployee(CriteriaDTO criteriaDTO);
}
