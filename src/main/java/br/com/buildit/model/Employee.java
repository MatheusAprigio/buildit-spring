package br.com.buildit.model;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "TB_EMPLOYEE")
@SequenceGenerator(name = "employee", allocationSize = 1, sequenceName = "SQ_EMPLOYEE", initialValue = 4)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "employee", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_employee")
    private Integer id;

    @Email(message = "O campo e-mail deve conter um @")
    @NotBlank(message = "O campo e-mail não pode estar vazio")
    @Size(min = 4, message = "O campo e-mail deve conter no mínimo 4 dígitos")
    @Column(name = "ds_email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O campo nome não pode estar vazio")
    @Size(min = 3, max = 20, message = "O campo nome deve conter no mínimo 3 dígitos e no máximo 20 dígitos")
    @Column(name="nm_employee", nullable = false)
    private String name;

    @NotBlank(message = "O campo senha não pode estar vazio")
    @Size(min = 6, message = "O campo nome deve conter no mínimo 6 dígitos")
    @Column(name = "ds_pwd", nullable = false)
    private String password;

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

    public Employee(String email, String name, String password, Role role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Employee() {
    }
}
