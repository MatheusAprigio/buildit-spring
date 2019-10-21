package br.com.buildit.controller;

import br.com.buildit.model.Employee;
import br.com.buildit.model.Role;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("employee")
public class AdminController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("admins/list")
    public String listAllAdmins(Model model) {

        model.addAttribute("admins", employeeRepository.findByRole(Role.ROLE_ADMIN));
        return "forms/admins";
    }

    @PostMapping("admins/delete")
    public String deleteAdmin(Integer id, RedirectAttributes redirectAttributes) {

        employeeRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Administrador deletado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("admins/add")
    public String addAdmin(Employee employee, RedirectAttributes redirectAttributes) {

        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Administrador cadastrado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("admins/edit")
    public String editAdmin(Employee employee, RedirectAttributes redirectAttributes) {

        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Administrador alterado com sucesso!");
        return "redirect:list";
    }

    @GetMapping("admins/list/filter")
    public String listAdminsFilter(Model model, @RequestParam String filter) {

        model.addAttribute("admins", employeeRepository.findByNameIsContainingIgnoreCaseOrEmailIsContainingIgnoreCase(filter, filter));
        return "forms/admins";
    }

}
