package br.com.buildit.controller;

import br.com.buildit.model.Product;
import br.com.buildit.repository.CategoryRepository;
import br.com.buildit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("list")
    public String listAllProducts(Model model){

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "forms/products";
    }

    @PostMapping("delete")
    public String deleteProduct(Integer id, RedirectAttributes redirectAttributes) {

        productRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Produto deletado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("add")
    public String addProduct(Product product, RedirectAttributes attributes){

        productRepository.save(product);
        attributes.addFlashAttribute("msg", "Produto cadastrado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("edit")
    public String editAdmin(Product product, RedirectAttributes redirectAttributes) {

        productRepository.save(product);
        redirectAttributes.addFlashAttribute("msg", "Produto atualizado com sucesso!");
        return "redirect:list";
    }
}
