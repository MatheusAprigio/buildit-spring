package br.com.buildit.resource;


import br.com.buildit.model.Product;
import br.com.buildit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("company/{companyName}")
    public List<Product> getProductsByCompany(@PathVariable String companyName){
        return productRepository.findByCompany(companyName);
    }

    @GetMapping("filter/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("category/{categoryName}")
    List<Product> getProductsByCategory(@PathVariable String categoryName){
        return productRepository.findByCategoryName(categoryName);
    }

    @GetMapping("company/{companyName}/category/{categoryName}")
    List<Product> getProductsByCategoryAndComany(@PathVariable String categoryName, @PathVariable String companyName){
        return productRepository.findByCategoryNameAndCompany(categoryName, companyName);
    }
}
