package com.example.RandomDemo.Config;

import org.springframework.stereotype.Component;

@Component
public class ConstantService {
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    public static final String NAME_SIZE_VALIDATION = "Name Should be at least 2 characters";

    public static final String PROJECT_NAME_VALIDATION = "project name should not null";

    public static final String NAME_VALIDATION = "Name Should not NUll";

    public static final String PINCODE_LENGTH_VALIDATION = "Pincode must be exactly 6 digits";
}
