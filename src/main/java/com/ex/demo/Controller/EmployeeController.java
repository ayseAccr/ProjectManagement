package com.ex.demo.Controller;


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


import com.ex.demo.Model.Employee;
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
    public String getOneEmployee(@PathVariable("employeeId")Long id,Model model){

       model.addAttribute("employee",employeeService.getOneEmployee(id));
       return "employee-update";
     
    }
    
    @PostMapping("/edit/{employeeId}")
    public String employeeUpdate(@PathVariable Long employeeId,@RequestBody Employee employee,BindingResult result,Model model){
        if(result.hasErrors()) {
			employee.setEmployeeId(employeeId);
			return "employee-update";
		}
       employeeService.employeeUpdate(employeeId,employee);
       model.addAttribute("employees",employeeService.findAll());
       return "redirect:/employees/all";
        
    }
  

    @DeleteMapping("/{employeeId}")
    public String deleteOneUser(@PathVariable Long employeeId){
        employeeService.deleteOneUser(employeeId);
        return "redirect:/employees/all";
    }
        
    // @GetMapping("/")
    // String index(Principal principal) {
    //     return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    // }
    }

