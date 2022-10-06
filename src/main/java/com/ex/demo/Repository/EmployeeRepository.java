package com.ex.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ex.demo.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

    @Override
    List<Employee>findAll();
     
    // @Query(nativeQuery = true,value = "SELECT EMPLOYEE_ID,employee.first_name,project.project_id"+
    // "FROM project"+
    // "LEFT JOIN employee"+
    //      "ON project.project_id = employee.project_id")
    // List<Employee> findEmployees();
}
