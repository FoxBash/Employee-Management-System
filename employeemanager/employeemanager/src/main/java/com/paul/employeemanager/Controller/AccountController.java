package com.paul.employeemanager.Controller;


import com.paul.employeemanager.Model.Account;
import com.paul.employeemanager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/register/save")
    public String saveAccount(@ModelAttribute Account account){
        account.setPassword(passwordEncoder().encode(account.getPassword()));
        service.addAccount(account);
        return "redirect:/login";
    }
}
