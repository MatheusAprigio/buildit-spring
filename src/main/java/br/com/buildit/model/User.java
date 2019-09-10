package br.com.buildit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USER")
@SequenceGenerator(name = "user", allocationSize = 1, sequenceName = "SQ_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_user")
    private Integer code;

    @Column(name = "ds_email", nullable = false, unique = true)
    private String email;

    @Column(name="nm_user", nullable = false)
    private String name;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User(String email, String name, String password, Role role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
