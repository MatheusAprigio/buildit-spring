package br.com.buildit.resource;

import br.com.buildit.model.Order;
import br.com.buildit.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de pedidos de compra")
@RestController
@RequestMapping("api/v1/orders")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @ApiOperation(value = "Retorna uma lista com todos os pedidos de um cliente a partir do email do cliente")
    @GetMapping
    private List<Order> getAllOrdersByEmail(@RequestParam String email) {
        return orderRepository.findDistinctByCustomer_Email(email);
    }

    @ApiOperation(value = "Cria um novo pedido associado obrigatoriamente a um cliente ")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Order saveOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
