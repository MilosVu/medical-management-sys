package rs.naprednejava.medicalmanagementsys.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.User;
import rs.naprednejava.medicalmanagementsys.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    //Get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    //Login
    @PostMapping("/login")
    public List<User> login(@RequestBody User user){
    	return userRepository.findByUsernameAndPasswordAndUserRole(user.getUsername(), user.getPassword(), user.getUserRole());
    }
    
    //Get user by id
    @GetMapping("/users/{id}")
 	public ResponseEntity<User> getUsersById(@PathVariable Long id) {
    	User user = userRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
 		return ResponseEntity.ok(user);
 	}

    @DeleteMapping("/users/{id}")
   	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
   		User user = userRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
   		
   		userRepository.delete(user);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}

}
