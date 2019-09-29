package br.com.buildit.config.security;

import br.com.buildit.model.Employee;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CustomContextHolder {

    @Autowired
    EmployeeRepository employeeRepository;

    public String getCompany(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = employeeRepository.findByEmail(email);

        return employee.getEmployeeCompany().getCorporateName();
    }
}
