package br.com.buildit.model;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_order", nullable = false)
    private Date orderDate;

    @OneToOne
    @JoinColumn(name = "cd_customer")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "cd_driver")
    private Driver driver;

    @OneToMany(mappedBy = "order")
    List<OrderProduct> orderProducts;
}
