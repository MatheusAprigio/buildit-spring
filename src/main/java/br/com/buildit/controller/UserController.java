package br.com.buildit.controller;

import br.com.buildit.model.Employee;
import br.com.buildit.model.Role;
import br.com.buildit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("employee")
public class UserController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("users/list")
    public String listAllCommonUsers(Model model) {

        model.addAttribute("users", employeeRepository.findByRole(Role.ROLE_USER));
        return "forms/users";
    }

    @PostMapping("users/delete")
    public String deleteUser(Integer id, RedirectAttributes redirectAttributes) {

        employeeRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Usuário deletado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("users/add")
    public String addUser(@Valid Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Usuário cadastrado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("users/edit")
    public String editUser(@Valid Employee employee, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Usuário alterado com sucesso!");
        return "redirect:list";
    }

    @GetMapping("users/list/filter")
    public String listAdminsFilter(Model model, @RequestParam String filter) {

        model.addAttribute("users", employeeRepository.findByNameIsContainingIgnoreCaseOrEmailIsContainingIgnoreCase(filter, filter));
        return "forms/users";
    }
}
