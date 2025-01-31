package com.example.RandomDemo.Controllers;

import com.example.RandomDemo.DTO.EmployeeDTO;
import com.example.RandomDemo.DTO.SearchDTO;
import com.example.RandomDemo.Services.Interface.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid EmployeeDTO employee)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/searchEmployee")
    public ResponseEntity<?> searchEmployee(@RequestBody SearchDTO searchDTO){
        return new ResponseEntity<>(employeeService.searchEmployee(searchDTO.getCriteriaDTO()), HttpStatus.OK);
    }

}
