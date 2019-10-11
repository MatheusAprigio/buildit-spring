package br.com.buildit.resource;

import br.com.buildit.model.Customer;
import br.com.buildit.model.Driver;
import br.com.buildit.repository.DriverRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Operações para manipulação/visualização de motoristas")
@RestController
@RequestMapping("api/v1/drivers")
public class DriverResource {

    @Autowired
    private DriverRepository driverRepository;

    @ApiOperation(value = "Cria um motorista")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Driver createDriver(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @ApiOperation(value = "Atualiza os dados de um motorista")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Driver updateDriver(@PathVariable int id, Driver driver) {
        driver.setId(id);
        return driverRepository.save(driver);
    }

    @ApiOperation(value = "Deleta um motorista")
    @DeleteMapping("{id}")
    public void deleteDriver(@PathVariable int id){
        driverRepository.deleteById(id);
    }
}
