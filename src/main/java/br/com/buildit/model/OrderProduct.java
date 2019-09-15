package br.com.buildit.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDER_PRODUCT")
@SequenceGenerator(name = "orderProduct", allocationSize = 1, sequenceName = "SQ_ORDERPRODUCT")
public class OrderProduct{

    @Id
    @GeneratedValue(generator = "oderProduct", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_order_product")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cd_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cd_product")
    private Product product;

    @Column(name = "nr_quantity")
    private Integer quantity;

}
