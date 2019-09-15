package br.com.buildit.repository;

import br.com.buildit.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Integer> {

}
