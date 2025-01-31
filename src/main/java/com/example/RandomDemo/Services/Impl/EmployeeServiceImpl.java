package com.example.RandomDemo.Services.Impl;

import com.example.RandomDemo.DTO.CriteriaDTO;
import com.example.RandomDemo.DTO.EmployeeDTO;
import com.example.RandomDemo.Exceptions.EmployeeSaveException;
import com.example.RandomDemo.Exceptions.EmployeeSearchException;
import com.example.RandomDemo.Models.Employee;
import com.example.RandomDemo.Repository.EmployeeRepository;
import com.example.RandomDemo.Services.Interface.EmployeeService;
import com.example.RandomDemo.Utils.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Mapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Object saveEmployee(EmployeeDTO employeeDTO) {
        try {
            log.info("Saving employee data for: {}", employeeDTO.getName());
            Employee employee = mapper.toEntity(employeeDTO);
            Employee savedEmployee = employeeRepository.save(employee);
            log.info("Employee saved successfully with ID: {}", savedEmployee.getId());
            return mapper.toDTO(savedEmployee);
        } catch (DataIntegrityViolationException e) {
            log.error("Data integrity violation occurred while saving employee: {}", employeeDTO.getName(), e);
            throw new EmployeeSaveException("Error saving employee due to data integrity violation", e);
        } catch (Exception e) {
            log.error("Unexpected error occurred while saving employee: {}", employeeDTO.getName(), e);
            throw new RuntimeException("Error occurred while saving employee", e);
        }
    }

    @Override
    public Object searchEmployee(CriteriaDTO criteriaDTO) {
        try {
            if (criteriaDTO == null) {
                log.info("Criteria is null, returning all employees.");
                return employeeRepository.findAll().stream()
                        .map(mapper::toDTO)
                        .collect(Collectors.toList());
            }

            Pageable pageable = PageRequest.of(
                    criteriaDTO.getPagination().getPageNumber() - 1,
                    criteriaDTO.getPagination().getPageSize(),
                    criteriaDTO.getSortByAsc() ? Sort.by("id").ascending() : Sort.by("id").descending()
            );

            if (criteriaDTO.getEmployeeId() != null) {
                log.info("Searching for employee with ID: {}", criteriaDTO.getEmployeeId());
                return employeeRepository.findById(criteriaDTO.getEmployeeId())
                        .map(employee -> List.of(mapper.toDTO(employee)))
                        .orElse(List.of());
            }

            Page<Employee> employeePage = employeeRepository.findAll(pageable);
            return employeePage.getContent().stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error while searching employee data", e);
            throw new EmployeeSearchException("Error while searching employee data", e);
        }
    }
}
