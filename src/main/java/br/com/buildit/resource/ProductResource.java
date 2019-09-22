package br.com.buildit.resource;


import br.com.buildit.model.Product;
import br.com.buildit.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de produtos")
@RestController
@RequestMapping("api/v1/product")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Retorna uma lista com todos os produtos")
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos de uma empresa")
    @GetMapping("company/{companyName}")
    public List<Product> getProductsByCompany(@PathVariable String companyName){
        return productRepository.findByCompany(companyName);
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos por nome de produto, sendo o nome incompleto ou completo (LIKE do SQL)")
    @GetMapping("filter/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos a partir do nome de uma categoria")
    @GetMapping("category/{categoryName}")
    List<Product> getProductsByCategory(@PathVariable String categoryName){
        return productRepository.findByCategoryName(categoryName);
    }

    @ApiOperation(value = "Retorna uma lista com todos os produtos a partir do nome de uma categoria e de uma empresa")
    @GetMapping("company/{companyName}/category/{categoryName}")
    List<Product> getProductsByCategoryAndCompany(@PathVariable String categoryName, @PathVariable String companyName){
        return productRepository.findByCategoryNameAndCompany(categoryName, companyName);
    }
}
