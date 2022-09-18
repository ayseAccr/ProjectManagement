package com.ex.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ex.demo.Model.Project;
import com.ex.demo.Repository.ProjectRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/projects")
public class ProjectController {
   
   @Autowired // for create instance
   ProjectRepository projectRepo;


   @GetMapping("/new") 
   public String displayProjectForm(Model model){
    Project aProject =new Project(); 
    model.addAttribute("project",aProject);
    return "new-project";

   }
   @PostMapping("/save")
   public String createProject(Project project,Model model){
       
      projectRepo.save(project);
      //use a redirect to prevent dublicate submission
      return "redirect:/projects/new";
   }
   



}
