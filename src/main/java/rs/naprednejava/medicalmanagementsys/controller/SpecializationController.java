package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.Specialization;
import rs.naprednejava.medicalmanagementsys.repository.SpecializationRepository;

@RestController
@RequestMapping("/api/v1/")
public class SpecializationController {

	@Autowired
    private SpecializationRepository specializationRepository;
    
    //Get all users
    @GetMapping("/specializations")
    public List<Specialization> getAllSpecializations(){
        return specializationRepository.findAll();
    }
	
}
