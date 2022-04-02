package rs.naprednejava.medicalmanagementsys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.User;
import rs.naprednejava.medicalmanagementsys.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		 return userRepository.findAll();
	}
	
	public List<User> login(User user){
		System.out.println("=======================");
    	System.out.println(user);
    	System.out.println("=======================");
    	
    	return userRepository.findByUsernameAndPasswordAndUserRole(user.getUsername(), user.getPassword(), user.getUserRole());
    
	}
	
	 
	 	public ResponseEntity<User> getUsersById(Long id) {
	    	User user = userRepository.findById(id)
	 				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
	 		return ResponseEntity.ok(user);
	 	}

	    
	   	public ResponseEntity<Map<String, Boolean>> deleteUser(Long id){
	   		User user = userRepository.findById(id)
	   				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
	   		
	   		userRepository.delete(user);
	   		Map<String, Boolean> response = new HashMap<>();
	   		response.put("deleted", Boolean.TRUE);
	   		return ResponseEntity.ok(response);
	   	}
	    
	    
	   	public User updateUser(User user) {
	   		user.setUserRole("receptionist");
	   		return userRepository.save(user);
	   	}
	
}
