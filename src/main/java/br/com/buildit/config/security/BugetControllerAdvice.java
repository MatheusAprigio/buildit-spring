package br.com.buildit.config.security;

import br.com.buildit.model.Employee;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class BugetControllerAdvice {

    @Autowired
    EmployeeRepository employeeRepository;

    @ModelAttribute
    public void addBugetToModel(Model model) {
        try{
            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            Employee employee = employeeRepository.findByEmail(email);
            model.addAttribute("employee", employee);
        }catch (NullPointerException e){}
    }
}