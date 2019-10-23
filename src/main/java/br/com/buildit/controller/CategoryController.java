package br.com.buildit.controller;

import br.com.buildit.model.Category;
import br.com.buildit.model.Product;
import br.com.buildit.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("list")
    public String listAllProducts(Model model, Product product) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "forms/category";
    }

    @GetMapping("list/filter")
    public String listProductsFilter(Model model, String filter) {

        model.addAttribute("categories", categoryRepository.findByNameIsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCase(filter, filter));
        return "forms/category";
    }

    @PostMapping("delete")
    public String deleteProduct(Integer id, RedirectAttributes redirectAttributes) {

        categoryRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Categoria deletada com sucesso!");
        return "redirect:list";
    }

    @PostMapping("add")
    public String addProduct(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        categoryRepository.save(category);
        redirectAttributes.addFlashAttribute("msg", "Categoria cadastrada com sucesso!");
        return "redirect:list";
    }

    @PostMapping("edit")
    public String editAdmin(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:list";
        }

        categoryRepository.save(category);
        redirectAttributes.addFlashAttribute("msg", "Categoria atualizada com sucesso!");
        return "redirect:list";
    }
}
