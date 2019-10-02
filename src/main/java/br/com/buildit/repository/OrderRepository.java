package br.com.buildit.repository;

import br.com.buildit.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {
    List<Order> findDistinctByCustomer_Email(String email);
}
