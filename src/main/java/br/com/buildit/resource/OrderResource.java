package br.com.buildit.resource;

import br.com.buildit.model.Order;
import br.com.buildit.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de pedidos de compra")
@RestController
@RequestMapping("api/v1/order")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @ApiOperation(value = "Retorna uma lista com todos os pedidos de um cliente a partir do email do cliente")
    @GetMapping("{email}")
    private List<Order> getAllOrdersByEmail(@PathVariable String email){
        return orderRepository.findDistinctByCustomer_Email(email);
    }

}
