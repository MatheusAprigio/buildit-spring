package br.com.buildit.controller;

import br.com.buildit.repository.OrderProductRepository;
import br.com.buildit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @GetMapping("list")
    public String listAllOrders(Model model){

        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("orderProduct", orderProductRepository.findAll());
        return "forms/orders";
    }

}
