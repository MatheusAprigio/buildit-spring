package br.com.buildit.controller;

import br.com.buildit.model.Role;
import br.com.buildit.repository.EmployeeRepository;
import br.com.buildit.repository.OrderProductRepository;
import br.com.buildit.repository.OrderRepository;
import br.com.buildit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("overview")
public class OverviewController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String getOverview(Model model) {

        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("sumOrders", orderRepository.sumOrdersTotal());
        model.addAttribute("admin", employeeRepository.sumEmployeeByRole(Role.ROLE_ADMIN));
        model.addAttribute("user", employeeRepository.sumEmployeeByRole(Role.ROLE_USER));
        model.addAttribute("sumProducts", productRepository.sumNumProducts());
        return "forms/overview";
    }
}
