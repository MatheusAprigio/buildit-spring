package br.com.buildit.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CUSTOMER")
@AttributeOverride(name = "id", column = @Column(name = "cd_customer"))
public class Customer extends  AppUser{

}
