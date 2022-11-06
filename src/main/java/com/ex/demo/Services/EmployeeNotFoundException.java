package com.ex.demo.Services;

public class EmployeeNotFoundException extends Throwable{

    public EmployeeNotFoundException(String message) {
        super(message);
    }

}
