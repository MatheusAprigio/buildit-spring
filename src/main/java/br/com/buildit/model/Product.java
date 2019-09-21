package br.com.buildit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT")
@SequenceGenerator(name = "product", allocationSize = 1, sequenceName = "SQ_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_product")
    private String id;

    @Column(name = "nm_sku", nullable = false)
    private String SKU;

    @Column(name = "fl_product", nullable = true)
    private String picture;

    @Column(name = "nm_product", nullable = false)
    private String name;

    @Column(name = "ds_product", nullable = false)
    private String description;

    @Column(name = "ds_measure", nullable = true)
    private String measure;

    @Column(name = "vl_product", nullable = false)
    private double unitPrice;

    @OneToOne
    @JoinColumn(name = "cd_company")
    private Company productCompany;

    @ManyToOne
    @JoinColumn(name = "cd_category")
    private Category category;

    @OneToMany(mappedBy = "product")
    List<OrderProduct> orderProducts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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

    public Company getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(Company productCompany) {
        this.productCompany = productCompany;
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

    public Product(String SKU, String picture, String name, String description, String measure, double unitPrice, Company productCompany, Category category, List<OrderProduct> orderProducts) {
        this.SKU = SKU;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.measure = measure;
        this.unitPrice = unitPrice;
        this.productCompany = productCompany;
        this.category = category;
        this.orderProducts = orderProducts;
    }

    public Product(){

    }
}
