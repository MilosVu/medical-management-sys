package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
