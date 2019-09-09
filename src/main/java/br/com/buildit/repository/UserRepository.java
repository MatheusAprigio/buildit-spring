package br.com.buildit.repository;

import br.com.buildit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    User findByEmailAndPassword(String name, String password);
    void deleteByEmail(String email);
}
