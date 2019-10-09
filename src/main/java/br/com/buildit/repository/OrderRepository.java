package br.com.buildit.repository;

import br.com.buildit.model.Order;
import br.com.buildit.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

    List<Order> findDistinctByCustomer_Email(String email);

    List<Order> findByStatus(Status status);
}
