package br.com.buildit.resource;


import br.com.buildit.model.Customer;
import br.com.buildit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/customer")
public class CustomerResource {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("{email}/{password}")
    public Customer getCustomerByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return customerRepository.findByEmailAndPassword(email, password);
    }
}
