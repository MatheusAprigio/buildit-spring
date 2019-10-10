package br.com.buildit.repository;

import br.com.buildit.model.Order;
import br.com.buildit.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findDistinctByCustomer_Email(String email);

    List<Order> findByStatus(Status status);

    List<Order> findByCustomer_NameIsContainingIgnoreCaseOrCustomer_EmailIsContainingIgnoreCaseOrDriver_NameIsContainingIgnoreCaseOrDriver_EmailIsContainingIgnoreCase(String customerName, String customerEmail, String driverName, String driverEmail);

    List<Order> findByStatusAndCustomer_NameIsContainingIgnoreCaseOrCustomer_EmailIsContainingIgnoreCaseOrDriver_NameIsContainingIgnoreCaseOrDriver_EmailIsContainingIgnoreCase(Status status, String customerName, String customerEmail, String driverName, String driverEmail);

    @Query("Update Order o set o.status  = 'CANCELADO' where o.id = ?1")
    @Modifying
    Order updateOrderStatus(Integer id);

}
