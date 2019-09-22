package br.com.buildit.resource;


import br.com.buildit.model.Customer;
import br.com.buildit.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Operações para manipulação/visualização de usuários (Clientes finais - APP)")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @ApiOperation(value = "Retorna um único usuário (Cliente final) a partir de um usuário e senha")
    @GetMapping("{email}/{password}")
    public Customer getCustomerByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return customerRepository.findByEmailAndPassword(email, password);
    }
}
