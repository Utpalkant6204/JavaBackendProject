package com.example.RandomDemo.Exceptions;

public class EmployeeSearchException extends RuntimeException{

    public EmployeeSearchException(String message) {
        super(message);
    }

    public EmployeeSearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
