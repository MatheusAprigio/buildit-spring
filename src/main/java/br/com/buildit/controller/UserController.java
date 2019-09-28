package br.com.buildit.controller;

import br.com.buildit.model.Employee;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("save")
    public void saveUser(@RequestBody Employee user){
        employeeRepository.save(user);
    }

}
