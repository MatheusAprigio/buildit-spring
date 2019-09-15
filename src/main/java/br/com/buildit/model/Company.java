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

    @OneToMany(mappedBy = "employeeCompany")
    private List<Employee> employee;

    @OneToOne(mappedBy = "productCompany")
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNationalRegistry() {
        return nationalRegistry;
    }

    public void setNationalRegistry(Integer nationalRegistry) {
        this.nationalRegistry = nationalRegistry;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Company(String tradingName, String corporateName, String address, Integer nationalRegistry, List<Employee> employee, Product product) {
        this.tradingName = tradingName;
        this.corporateName = corporateName;
        this.address = address;
        this.nationalRegistry = nationalRegistry;
        this.employee = employee;
        this.product = product;
    }

    public Company() {
    }
}
