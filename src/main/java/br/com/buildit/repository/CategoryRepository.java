package br.com.buildit.repository;

import br.com.buildit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {

    List<Category> findByNameIsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCase(String name, String description);
}
