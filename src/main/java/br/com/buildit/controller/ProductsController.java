package br.com.buildit.controller;

import br.com.buildit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String listAllProducts(){
        return "forms/products";
    }
}
