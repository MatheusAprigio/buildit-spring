package br.com.buildit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_COMPANY")
@SequenceGenerator(name = "company", allocationSize = 1, sequenceName = "SQ_COMPANY")
public class Company {

    @Id
    @GeneratedValue(generator = "company", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_company")
    private Integer id;

    @Column(name = "nm_trading_name", nullable = false)
    private String tradingName;

    @Column(name = "nm_corporate_name", nullable = false)
    private String corporateName;

    @Column(name = "ds_address")
    private String address;

    @Column(name = "nr_natonal_registry", nullable = false)
    private Integer nationalRegistry;

    @OneToOne(mappedBy = "employeeCompany")
    private Employee employee;

    @OneToOne(mappedBy = "productCompany")
    private Product product;
}
