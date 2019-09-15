package br.com.buildit.repository;

import br.com.buildit.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    Employee findByEmailAndPassword(String name, String password);
    void deleteByEmail(String email);
}
