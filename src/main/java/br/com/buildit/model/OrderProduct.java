package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDER_PRODUCT")
@SequenceGenerator(name = "orderProduct", allocationSize = 1, sequenceName = "SQ_ORDERPRODUCT")
public class OrderProduct{

    @Id
    @GeneratedValue(generator = "orderProduct", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_order_product")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cd_order")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cd_product")
    private Product product;

    @Column(name = "nr_quantity")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderProduct(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProduct() {
    }
}
