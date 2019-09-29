package br.com.buildit.controller;

import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("admin")
    public String listAllAdmins(){
        return "forms/admins";
    }

    @GetMapping("user")
    public String listAllCommonUsers(){
        return "forms/admins";
    }
}
