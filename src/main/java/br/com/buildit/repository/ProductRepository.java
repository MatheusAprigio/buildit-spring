package br.com.buildit.repository;

import br.com.buildit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
    
    List<Product> findByCategory_Name(String categoryName);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findBySkuIsContainingIgnoreCaseOrNameIsContainingIgnoreCaseOrCategory_NameIsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCaseOrMeasureIsContainingIgnoreCase(String sku, String name, String categoryName, String description, String measure);

    List<Product> findByIsActive(Boolean isActive);

    @Query("select count(p.id) from Product p")
    String sumNumProducts();
}
