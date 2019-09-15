package br.com.buildit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORY")
@SequenceGenerator(name = "category", allocationSize = 1, sequenceName = "SQ_CATEGORY")
public class Category {

    @Id
    @GeneratedValue(generator = "category", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_category")
    private Integer id;

    @Column(name = "ds_category", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(referencedColumnName = "cd_category")
    private Category category;

    @Column(name = "cd_product")
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category(String description, Category category, List<Product> products) {
        this.description = description;
        this.category = category;
        this.products = products;
    }

    public Category() {
    }
}
