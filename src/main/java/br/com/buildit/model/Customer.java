package br.com.buildit.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "customer", allocationSize = 1, sequenceName = "SQ_CUSTOMER")
@Table(name = "TB_CUSTOMER")
@SequenceGenerator(name = "customer", allocationSize = 1, sequenceName = "SQ_CUSTOMER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer {

    @Id
    @GeneratedValue(generator = "customer", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_customer")
    private Integer id;

    @Column(name = "nm_customer", nullable = false)
    private String name;

    @Column(name = "fl_customer", nullable = true)
    private  byte[] picture;

    @Column(name = "ds_email", nullable = false)
    private  String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "ds_pwd", nullable = false)
    private String password;

    @Column(name = "nr_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "nr_cpf", nullable = false)
    private Integer cpf;

    @Column(name = "ds_address", nullable = false)
    private String address;

    @OneToOne(mappedBy = "customer")
    private Order order;

}
