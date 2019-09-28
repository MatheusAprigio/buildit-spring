package br.com.buildit.repository;

import br.com.buildit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {

    @Override
    List<Product> findAll();

    @Query(value = "SELECT p FROM Product p where p.productCompany.corporateName = ?1")
    List<Product> findByCompany(String name);

    @Query(value = "SELECT p FROM Product p where p.category.name = ?1")
    List<Product> findByCategoryName(String categoryName);

    @Query(value = "SELECT p FROM Product p where p.category.name = ?1 and p.productCompany.corporateName = ?2 ")
    List<Product> findByCategoryNameAndCompany(String companyName, String categoryName);

    List<Product> findByNameContainingIgnoreCase(String name);

}
