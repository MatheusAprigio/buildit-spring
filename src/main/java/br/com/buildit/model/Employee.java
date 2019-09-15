package br.com.buildit.model;

import javax.persistence.*;


@Entity
@Table(name = "TB_EMPLOYEE")
@SequenceGenerator(name = "employee", allocationSize = 1, sequenceName = "SQ_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_employee")
    private Integer id;

    @Column(name = "ds_email", nullable = false, unique = true)
    private String email;

    @Column(name="nm_employee", nullable = false)
    private String name;

    @Column(name = "ds_pwd", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "cd_company", unique = false)
    private Company employeeCompany;

    @Column(name = "ds_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer code) {
        this.id = code;
    }

    public Employee(String email, String name, String password, Role role, Company company) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.employeeCompany = company;
    }

    public Employee() {
    }
}
