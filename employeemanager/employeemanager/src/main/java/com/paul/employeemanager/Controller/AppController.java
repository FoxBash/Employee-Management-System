package com.paul.employeemanager.Controller;


import com.paul.employeemanager.Model.Account;
import com.paul.employeemanager.Model.Employee;
import com.paul.employeemanager.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private EmpService service;


    @GetMapping("/")
    private String home(){
        return "index";
    }
    @GetMapping("/view")
    private String view(Model model){
        model.addAttribute("employees", service.getEmployees());
        return "viewEmployee";
    }

    @GetMapping("/addEmp")
    public String addEmployee(Model model){
        model.addAttribute("emp", new Employee());
        return "addEmp";
    }

    @PostMapping("/addEmp/save")
    public String saveEmp(@ModelAttribute Employee employee){
        service.addEmployee(employee);
        return "redirect:/view";
    }

    @GetMapping("/update/{id}")
    public String updateEmp(@PathVariable("id") Long id,Model model){
        Optional<Employee> optionalEmployee = service.findOneById(id);
        if ( optionalEmployee.isPresent() ){
            Employee employee =optionalEmployee.get();
            model.addAttribute("emp", employee);
            return "updateEmp";
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Long id){
        Optional<Employee> optionalEmployee = service.findOneById(id);
        if ( optionalEmployee.isPresent() ){
            Employee employee =optionalEmployee.get();
            service.deleteEmp(employee);
            return "redirect:/";
        }
        return null;
    }
    @GetMapping("/view/{id}")
    public String viewEmp(@PathVariable("id") Long id,Model model){
        Optional<Employee> optionalEmployee =  service.findOneById(id);
        if ( optionalEmployee.isPresent() ){
            Employee employee = optionalEmployee.get();
            model.addAttribute("emp", employee);
            return "viewIndEmp";
        }
        else{
            try {
                throw new AccountNotFoundException("Could not find  employee");
            } catch (AccountNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
