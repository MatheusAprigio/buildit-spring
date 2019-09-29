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
    void deleteByEmail(String email);

    Employee findByEmail(String email);

    @Query("Select e from Employee e where e.role = ?1 and e.employeeCompany.corporateName = ?2")
    List<Employee> findByRoleAndCompany(Role role, String companyName);
}
