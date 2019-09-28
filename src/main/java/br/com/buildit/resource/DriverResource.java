package br.com.buildit.resource;

import br.com.buildit.model.Driver;
import br.com.buildit.repository.DriverRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "Operações para manipulação/visualização de motoristas")
@RestController
@RequestMapping("api/v1/drivers")
public class DriverResource {

    @Autowired
    private DriverRepository driverRepository;

    @ApiOperation(value = "Retorna um único motorista a partir de um email e uma senha")
    @PostMapping
    public Driver getDriverByNameAndEmail(@RequestParam String email, @RequestParam String password){
        return driverRepository.findByEmailAndPassword(email, password);
    }
}
