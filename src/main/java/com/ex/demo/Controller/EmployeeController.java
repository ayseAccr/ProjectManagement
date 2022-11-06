package com.ex.demo.Controller;


import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ex.demo.Model.Employee;
import com.ex.demo.Services.EmployeeNotFoundException;
import com.ex.demo.Services.EmployeeService;
@Controller

@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    

    @GetMapping("/all")
    public String displayEmployees(Model model){
        
        model.addAttribute("AllEmployeesList",employeeService.findAll());
        //return employeeService.findAll();
        return "employee-page";
  
    }

    @GetMapping("/new") 
    public String displayEmployeeForm(Model model){
       Employee anEmployee =new Employee();
       model.addAttribute("employee",anEmployee);
       return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee){
        
       employeeService.saveOneEmployee(employee);
       //use a redirect to prevent dublicate submission
       return "redirect:/employees/new";
    }

    @GetMapping("/edit/{employeeId}")
    public String showUpdateForm(@PathVariable("employeeId")Long id,Model model,RedirectAttributes ra){

      Employee employee = employeeService.getOneEmployee(id);
      model.addAttribute("employee",employee);
      return "employee-update";
       
    }
    
    //@PostMapping("/edit/{employeeId}")
    @PostMapping(value={"/edit/{employeeId}"},consumes = {"application/xml","application/json","application/x-www-form-urlencoded"}
   )
    public String employeeUpdate(@PathVariable("employeeId")Long id,Employee employee,BindingResult result,Model model){
      
        if(result.hasErrors()) {
			employee.setEmployeeId(id);
			return "employee-update";
		}
       employeeService.employeeUpdate(id,employee);
       model.addAttribute("employee",employeeService.findAll());
       return "redirect:/employees/all";
        
    }
  

    @GetMapping("/deleteEmployee/{employeeId}")
    public String deleteOneUser(@PathVariable Long employeeId){
        employeeService.deleteOneUser(employeeId);
        return "redirect:/employees/all";
    }
        
   
    }

