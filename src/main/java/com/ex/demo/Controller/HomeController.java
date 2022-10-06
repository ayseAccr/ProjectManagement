package com.ex.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ex.demo.Model.Employee;
import com.ex.demo.Model.Project;
import com.ex.demo.Repository.EmployeeRepository;
import com.ex.demo.Repository.ProjectRepository;



@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepo;
    
    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model){
      
        List<Project>projects=(List<Project>)projectRepo.findAll();
        model.addAttribute("projectsList",projects);
       
        return "home";
    }
   
    
    

}
