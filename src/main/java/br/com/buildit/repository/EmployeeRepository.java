package br.com.buildit.repository;

import br.com.buildit.model.Employee;
import br.com.buildit.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    Employee findByEmailAndPassword(String name, String password);

    Employee findByEmail(String email);

    List<Employee> findByRole(Role role);
}
