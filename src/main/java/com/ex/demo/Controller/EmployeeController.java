package com.ex.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.demo.Model.Employee;
import com.ex.demo.Repository.EmployeeRepository;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/new") 
    public String displayEmployeeForm(Model model){
    Employee anEmployee =new Employee(); 
    model.addAttribute("employee",anEmployee);
    return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model){
        
        employeeRepo.save(employee);
       //use a redirect to prevent dublicate submission
       return "redirect:/employees/new";
    }

    
}
