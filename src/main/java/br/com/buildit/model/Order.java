package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name=" TB_ORDER")
@SequenceGenerator(name ="order", allocationSize = 1, sequenceName = "SQ_ORDER")
public class Order {

    @Id
    @GeneratedValue(generator = "order", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_order")
    private Integer id;

    @Column(name = "vl_order", nullable = false)
    private double orderValue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_order", nullable = false)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_status", nullable = false)
    Status status;

    @OneToOne
    @JoinColumn(name = "cd_customer")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "cd_driver")
    private Driver driver;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "order")
    List<OrderProduct> orderProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Order(double orderValue, Date orderDate, Customer customer, Driver driver, List<OrderProduct> orderProducts, Status status) {
        this.orderValue = orderValue;
        this.orderDate = orderDate;
        this.customer = customer;
        this.driver = driver;
        this.orderProducts = orderProducts;
        this.status = status;
    }

    public Order() {}
}
