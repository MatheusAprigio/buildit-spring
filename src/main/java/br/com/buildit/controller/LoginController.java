package br.com.buildit.controller;

import br.com.buildit.model.Employee;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("signin")
    public String getLogin(){
        return "signin";
    }

    @GetMapping("/")
    public String getDashboard(Model model){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = employeeRepository.findByEmail(email);
        model.addAttribute("name", employee.getName());

        return "forms/overview";
    }
}
