package com.ex.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ex.demo.Model.Employee;
import com.ex.demo.Repository.EmployeeRepository;


@Service //used for implementing business logic

public class EmployeeService {
    
    EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepo = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
        
    }
    
    public Employee saveOneEmployee(Employee newEmployee) {
        return employeeRepo.save(newEmployee);
    }
    
    public Employee getOneEmployee(Long employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
       
    }
    
    public Employee employeeUpdate(Long employeeId, Employee updateEmployee) {
      
       Optional<Employee> employee =employeeRepo.findById(employeeId);
       Employee foundEmployee = employee.get();
       foundEmployee.setFirstName(updateEmployee.getFirstName());
       foundEmployee.setLastName(updateEmployee.getLastName());
       foundEmployee.setEmail(updateEmployee.getEmail());
       employeeRepo.save(foundEmployee);
       return foundEmployee;
    }

    public void deleteOneUser(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }
     
    
}