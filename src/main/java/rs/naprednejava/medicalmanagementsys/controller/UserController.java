package rs.naprednejava.medicalmanagementsys.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.User;
import rs.naprednejava.medicalmanagementsys.repository.UserRepository;


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
    
}
