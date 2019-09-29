package br.com.buildit.controller;

import br.com.buildit.config.security.CustomContextHolder;
import br.com.buildit.model.Employee;
import br.com.buildit.model.Role;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Resource
    CustomContextHolder customContextHolder;

    @GetMapping("admin")
    public String listAllAdmins(Model model) {

        model.addAttribute("admins", employeeRepository.findByRoleAndCompany(Role.ROLE_ADMIN, customContextHolder.getCompany()));
        return "forms/admins";
    }

    @PostMapping("admin")
    public String deleteAdmin(Integer id, RedirectAttributes redirectAttributes) {

        employeeRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Administrador deletado com sucesso!");
        return "redirect:admin";
    }

    @GetMapping("user")
    public String listAllCommonUsers(Model model) {

        model.addAttribute("admins", employeeRepository.findByRoleAndCompany(Role.ROLE_USER, customContextHolder.getCompany()));
        return "forms/admins";
    }
}
