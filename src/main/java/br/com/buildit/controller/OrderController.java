package br.com.buildit.controller;

import br.com.buildit.model.Order;
import br.com.buildit.model.Status;
import br.com.buildit.repository.OrderProductRepository;
import br.com.buildit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;

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

    @PostMapping("cancel")
    public String cancelOrder(Integer id, RedirectAttributes redirectAttributes) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        order.setStatus(Status.CANCELADO);
        orderRepository.save(order);

        redirectAttributes.addFlashAttribute("msg", "Pedido cancelado com sucesso!");

        return "redirect:list";
    }
}
