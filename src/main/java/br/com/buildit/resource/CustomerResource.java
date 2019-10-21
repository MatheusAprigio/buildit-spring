package br.com.buildit.resource;

import br.com.buildit.model.Customer;
import br.com.buildit.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Api(description = "Operações para manipulação/visualização de usuários (Clientes finais - APP)")
@RestController
@RequestMapping("api/v1/customers")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @ApiOperation(value = "Retorna os dados de um usuário (Cliente final)")
    @GetMapping("{id}")
    Customer getCustomer(@PathVariable Integer id) {
        return customerRepository.findById(id).get();
    }

    @ApiOperation(value = "Cria um usuário (Cliente final)")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @ApiOperation(value = "Atualiza os dados de um usuário (Cliente final)")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Customer updateCustomer(@PathVariable int id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @ApiOperation(value = "Deleta um usuário (Cliente final)")
    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }
}
