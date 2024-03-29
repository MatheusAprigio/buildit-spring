package br.com.buildit.resource;

import br.com.buildit.model.Product;
import br.com.buildit.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de produtos")
@RestController
@RequestMapping("api/v1/products")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Retorna uma lista com todos os produtos")
    @GetMapping
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos por nome de produto, sendo o nome incompleto ou completo (LIKE do SQL)")
    @GetMapping("filter")
    List<Product> getProductsByName(@RequestParam String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos a partir do nome de uma categoria")
    @GetMapping("categories")
    List<Product> getProductsByCategory(@RequestParam String name){
        return productRepository.findByCategory_Name(name);
    }

}
