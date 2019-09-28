package br.com.buildit.resource;


import br.com.buildit.model.Customer;
import br.com.buildit.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "Operações para manipulação/visualização de usuários (Clientes finais - APP)")
@RestController
@RequestMapping("api/v1/customers")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @ApiOperation(value = "Retorna um único usuário (Cliente final) a partir de um usuário e senha")
    @PostMapping
    public Customer getCustomerByEmailAndPassword(@RequestParam String email, @RequestParam String password){
        return customerRepository.findByEmailAndPassword(email, password);
    }
}
