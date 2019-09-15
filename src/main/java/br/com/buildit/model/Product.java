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
    private byte[] photo;

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
}
