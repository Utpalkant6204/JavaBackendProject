package com.example.RandomDemo.DTO;

import com.example.RandomDemo.Config.ConstantService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class AddressDTO {
    
    private String state;
    
    private String city;
    
    private String locality;
    
    private String district;

    @Min(value = 100000, message = ConstantService.PINCODE_LENGTH_VALIDATION)
    @Max(value = 999999, message = ConstantService.PINCODE_LENGTH_VALIDATION)
    private Long pincode;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }
}
