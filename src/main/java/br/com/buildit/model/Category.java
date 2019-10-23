package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORY")
@SequenceGenerator(name = "category", allocationSize = 1, sequenceName = "SQ_CATEGORY", initialValue = 3)
public class Category {

    @Id
    @GeneratedValue(generator = "category", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_category")
    private Integer id;

    @NotBlank(message = "Nome da categoria não deve estar vazio")
    @Column(name = "nm_category")
    private String name;

    @NotBlank(message = "Descrição da categoria não deve estar vazio")
    @Column(name = "ds_category", nullable = true)
    private String description;

    @Column(name = "cd_product")
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    @PreRemove
    private void preRemove() {
        products.forEach(product -> product.setCategory(null));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category(String description, Category category, List<Product> products, String name) {
        this.description = description;
        this.products = products;
        this.name = name;
    }

    public Category() {
    }
}
