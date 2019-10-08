package br.com.buildit.repository;

import br.com.buildit.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository <OrderProduct, Integer> {

}
