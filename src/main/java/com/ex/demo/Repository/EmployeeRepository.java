package com.ex.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ex.demo.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    
}
