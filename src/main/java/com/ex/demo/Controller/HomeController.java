package com.ex.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ex.demo.Model.Project;
import com.ex.demo.Repository.ProjectRepository;



@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepo;


    @GetMapping("/")
    public String displayHome(Model model){
     
        List<Project>projects=projectRepo.findAll();
        model.addAttribute("projectsList",projects);
        return "Home";
    }

}
