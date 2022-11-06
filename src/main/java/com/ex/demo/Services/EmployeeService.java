package com.ex.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    public ResponseEntity<Employee> employeeUpdate(Long employeeId, Employee updateEmployee) {
       Optional<Employee> employee =employeeRepo.findById(employeeId);
       Employee foundEmployee = employee.get();
       foundEmployee.setFirstName(updateEmployee.getFirstName());
       foundEmployee.setLastName(updateEmployee.getLastName());
       foundEmployee.setEmail(updateEmployee.getEmail());
       foundEmployee.setTheProject(updateEmployee.getTheProject());
       
       Employee updatedEmployee =  employeeRepo.save(foundEmployee);
       return ResponseEntity.ok(updatedEmployee);
    }

    public void deleteOneUser(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    public Employee get(Long id) throws EmployeeNotFoundException {
        Optional<Employee> result = employeeRepo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new EmployeeNotFoundException("Could not find any result"+id);

    }
     
    
}
