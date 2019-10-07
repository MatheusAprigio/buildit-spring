package br.com.buildit.repository;

import br.com.buildit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.rmi.PortableRemoteObject;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
    
    List<Product> findByCategory_Name(String categoryName);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByNameContainsIgnoreCaseOrSkuContainsIgnoreCaseOrCategory_NameContainsIgnoreCaseOrderBySku(String name, String sku, String category);
}
