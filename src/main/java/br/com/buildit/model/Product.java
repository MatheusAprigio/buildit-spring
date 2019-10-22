package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT")
@SequenceGenerator(name = "product", allocationSize = 1, sequenceName = "SQ_PRODUCT" , initialValue = 4)
public class Product {

    @Id
    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_product")
    private Integer id;

    @Column(name = "nm_sku", nullable = false)
    private String sku;

    @Column(name = "fl_product", nullable = true)
    private String picture;

    @Column(name = "nm_product", nullable = false)
    private String name;

    @Column(name = "ds_product", nullable = false)
    private String description;

    @Column(name = "ds_measure", nullable = false)
    private String measure;

    @Column(name = "vl_product", nullable = false)
    private double unitPrice;

    @Column(name = "bl_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "cd_category")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    List<OrderProduct> orderProducts;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String SKU) {
        this.sku = SKU;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String photo) {
        this.picture = photo;
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Product(String sku, String picture, String name, String description, String measure, double unitPrice, Category category, List<OrderProduct> orderProducts, Boolean isActive) {
        this.sku = sku;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.measure = measure;
        this.unitPrice = unitPrice;
        this.category = category;
        this.orderProducts = orderProducts;
        this.isActive = isActive;
    }

    public Product(){

    }
}
