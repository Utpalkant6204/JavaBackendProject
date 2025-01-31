package com.example.RandomDemo.Models;

import com.example.RandomDemo.Config.ConstantService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table ( name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String city;

    private String locality;

    @Min(value = 100000, message = ConstantService.PINCODE_LENGTH_VALIDATION)
    @Max(value = 999999, message = ConstantService.PINCODE_LENGTH_VALIDATION)
    private Long pincode;

    private String district;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
    @JsonIgnore
    private Employee employee;

    public Address() {
    }

    public Address(Long id, String state, String city, String locality, Long pincode, String district, Employee employee) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.locality = locality;
        this.pincode = pincode;
        this.district = district;
        this.employee = employee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
