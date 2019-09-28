package br.com.buildit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@SequenceGenerator(name = "appuser", allocationSize = 1, sequenceName = "SQ_APPUSER")
public class AppUser {

    @Id
    @GeneratedValue(generator = "appuser", strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Integer id;

    @Column(name = "nm_user", nullable = false)
    private String name;

    @Column(name = "fl_picture", nullable = true)
    private  String picture;

    @Column(name = "ds_email", nullable = false)
    private  String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_birth", nullable = false)
    private Date birthDate;

    @Column(name = "ds_pwd", nullable = false)
    private String password;

    @Column(name = "nr_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "nr_cpf", nullable = false)
    private String cpf;

    @Column(name = "ds_address", nullable = true)
    private String address;

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public AppUser(String name, String picture, String email, Date birthDate, String password, String phoneNumber, String cpf, String address, Order order) {
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.address = address;
        this.order = order;
    }

    public AppUser(){

    }
}
