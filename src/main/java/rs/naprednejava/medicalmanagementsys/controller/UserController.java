package rs.naprednejava.medicalmanagementsys.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
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
    	return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    
}
