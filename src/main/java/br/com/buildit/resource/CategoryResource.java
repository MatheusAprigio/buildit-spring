package br.com.buildit.resource;

import br.com.buildit.model.Category;
import br.com.buildit.repository.CategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Operações para visualização de categorias")
@RestController
@RequestMapping("api/v1/categories")
public class CategoryResource {

    @Autowired
    CategoryRepository categoryRepository;

    @ApiOperation(value = "Retorna uma lista com todas as categorias disponíveis")
    @GetMapping
    List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @ApiOperation(value = "Retorna uma lista com todos as categorias a partir de um nome, podendo o nome ser completo ou não (LIKE SQL)")
    @GetMapping("filter")
    private List<Category> getAllCategoriesByName(@RequestParam String email) {
        return categoryRepository.findByNameIsContaining(email);
    }

}
