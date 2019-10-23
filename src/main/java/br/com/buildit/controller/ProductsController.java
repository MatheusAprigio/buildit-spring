package br.com.buildit.controller;

import br.com.buildit.model.Product;
import br.com.buildit.repository.CategoryRepository;
import br.com.buildit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("products")
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("list")
    public String listAllProducts(Model model, Product product) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findByIsActive(true));

        return "forms/products";
    }

    @GetMapping("list/filter")
    public String listProductsFilter(Model model, String filter) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.
                findBySkuIsContainingIgnoreCaseOrNameIsContainingIgnoreCaseOrCategory_NameIsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCaseOrMeasureIsContainingIgnoreCase(
                        filter, filter, filter, filter, filter));
        return "forms/products";
    }

    @PostMapping("delete")
    public String deleteProduct(Integer id, RedirectAttributes redirectAttributes) {

        Product product = productRepository.findById(id).get();
        product.setActive(false);
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("msg", "Produto deletado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("add")
    public String addProduct(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        productRepository.save(product);
        redirectAttributes.addFlashAttribute("msg", "Produto cadastrado com sucesso!");
        return "redirect:list";
    }

    @PostMapping("edit")
    public String editAdmin(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        productRepository.save(product);
        redirectAttributes.addFlashAttribute("msg", "Produto atualizado com sucesso!");
        return "redirect:list";
    }
}
