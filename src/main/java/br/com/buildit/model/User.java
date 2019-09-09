package br.com.buildit.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USER")
public class User implements Serializable {

    @Id
    @Column(name = "ds_email", nullable = false)
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

    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
