package com.ex.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ex.demo.Model.Employee;
import com.ex.demo.Model.Project;
import com.ex.demo.Repository.EmployeeRepository;
import com.ex.demo.Repository.ProjectRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/projects")
public class ProjectController {
   
   @Autowired // for create instance
   ProjectRepository projectRepo;

   @Autowired 
   EmployeeRepository employeeRepo;

   @GetMapping("/new") 
   public String displayProjectForm(Model model){
      Project aProject =new Project(); 
      List<Employee> employees =(List<Employee>)employeeRepo.findAll();
      model.addAttribute("project",aProject);
      model.addAttribute("allEmployees",employees);
      return "new-project";
   }
   @PostMapping("/save")
   public String createProject(Project project,@RequestParam List<Long> employees,Model model){
       
      projectRepo.save(project);
      Iterable<Employee> chosenEmployees = employeeRepo.findAllById(employees);
      for(Employee emp : chosenEmployees){
           emp.setTheProject(project);
           employeeRepo.save(emp);
      }
      //use a redirect to prevent dublicate submission
      return "redirect:/projects/new";
   }
   



}
