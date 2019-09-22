package br.com.buildit.resource;

import br.com.buildit.model.Driver;
import br.com.buildit.repository.DriverRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Operações para manipulação/visualização de motoristas")
@RestController
@RequestMapping("api/v1/driver")
public class DriverResource {

    @Autowired
    private DriverRepository driverRepository;

    @ApiOperation(value = "Retorna um único motorista a partir de um email e uma senha")
    @GetMapping("{email}/{password}")
    public Driver getDriverByNameAndEmail(@PathVariable String email, @PathVariable String password){
        return driverRepository.findByEmailAndPassword(email, password);
    }
}
