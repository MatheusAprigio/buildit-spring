package br.com.buildit.repository;

import br.com.buildit.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    Customer findByEmailAndPassword(String email, String password);
}
