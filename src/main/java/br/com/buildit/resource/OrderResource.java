package br.com.buildit.resource;

import br.com.buildit.model.Order;
import br.com.buildit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("{email}")
    private List<Order> getAllOrdersByEmail(@PathVariable String email){
        return orderRepository.findDistinctByCustomer_Email(email);
    }

}
