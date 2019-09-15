package br.com.buildit.repository;

import br.com.buildit.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository <Driver, Integer> {

}
