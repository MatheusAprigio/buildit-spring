package br.com.buildit.resource;

import br.com.buildit.model.Driver;
import br.com.buildit.model.Product;
import br.com.buildit.model.Vehicle;
import br.com.buildit.repository.VehicleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de veículos")
@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleResource {

    @Autowired
    private VehicleRepository vehicleRepository;

    @ApiOperation(value = "Retorna os dados de um veículo a partir do ID")
    @GetMapping("{id}")
    Vehicle getVehicle(@PathVariable Integer id) {
        return vehicleRepository.findById(id).get();
    }

    @ApiOperation(value = "Cria um veículo")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Vehicle createDriver(@RequestBody Vehicle driver) {
        return vehicleRepository.save(driver);
    }

    @ApiOperation(value = "Atualiza os dados de um veículo")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Vehicle updateDriver(@PathVariable int id, Vehicle vehicle) {
        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }

    @ApiOperation(value = "Deleta um veículo pelo ID")
    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleRepository.deleteById(id);
    }

    @ApiOperation(value = "Retorna uma lista com todos os veículos a partit do e-mail do motorista")
    @GetMapping("filter")
    List<Vehicle> getProductsByName(@RequestParam String email){
        return vehicleRepository.findByDriver_Email(email);
    }
}
