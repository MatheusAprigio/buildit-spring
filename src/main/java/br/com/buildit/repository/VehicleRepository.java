package br.com.buildit.repository;

import br.com.buildit.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {

    List<Vehicle> findByDriver_Email(String email);

}
