package br.com.buildit.resource;

import br.com.buildit.model.Driver;
import br.com.buildit.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/driver")
public class DriverResource {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("{email}/{password}")
    public Driver getDriverByNameAndEmail(@PathVariable String email, @PathVariable String password){
        return driverRepository.findByEmailAndPassword(email, password);
    }
}
