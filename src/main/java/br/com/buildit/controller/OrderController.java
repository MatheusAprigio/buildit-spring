package br.com.buildit.controller;

import br.com.buildit.model.Status;
import br.com.buildit.repository.OrderProductRepository;
import br.com.buildit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @GetMapping("list")
    public String listAllOrders(Model model) {

        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("orderProduct", orderProductRepository.findAll());
        return "forms/orders";
    }

    @GetMapping("list/status")
    public String lisrOrdersFilter(@RequestParam String status, @RequestParam String filter, Model model) {

        if (status.equals("NENHUM") && !filter.isEmpty()) {
            model.addAttribute("orders",
                    orderRepository.findByCustomer_NameIsContainingIgnoreCaseOrCustomer_EmailIsContainingIgnoreCaseOrDriver_NameIsContainingIgnoreCaseOrDriver_EmailIsContainingIgnoreCase(filter, filter, filter, filter));

        } else if (!status.equals("NENHUM") && !filter.isEmpty()) {
            model.addAttribute("orders",
                    orderRepository.findByStatusAndCustomer_NameIsContainingIgnoreCaseOrCustomer_EmailIsContainingIgnoreCaseOrDriver_NameIsContainingIgnoreCaseOrDriver_EmailIsContainingIgnoreCase(Status.valueOf(status), filter, filter, filter, filter));
        } else if (!status.equals("NENHUM") && filter.isEmpty()) {
            model.addAttribute("orders", orderRepository.findByStatus(Status.valueOf(status)));
        } else {
            model.addAttribute("orders", orderRepository.findAll());
        }

        model.addAttribute("orderProduct", orderProductRepository.findAll());
        return "forms/orders";
    }
}
