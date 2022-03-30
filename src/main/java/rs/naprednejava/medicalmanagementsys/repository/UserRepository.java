package rs.naprednejava.medicalmanagementsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	 List<User> findByUsernameAndPasswordAndUserRole(String username, String password, String userRole);

}
