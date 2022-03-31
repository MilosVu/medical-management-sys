package rs.naprednejava.medicalmanagementsys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.Specialization;
import rs.naprednejava.medicalmanagementsys.repository.SpecializationRepository;
import rs.naprednejava.medicalmanagementsys.service.SpecializationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SpecializationController {

	@Autowired
    private SpecializationService specializationService;
    
    //Get all specializations
    @GetMapping("/specializations")
    public List<Specialization> getAllSpecializations(){
        return specializationService.getAllSpecializations();
    }
    
	//Get specialization by id
   	@GetMapping("/specializations/{id}")
   	public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {
   		return specializationService.getSpecializationById(id);
   	}
   	
  //Delete specializations
   	@DeleteMapping("/specializations/{id}")
   	public ResponseEntity<Map<String, Boolean>> deleteSpecialization(@PathVariable Long id){
   		return specializationService.deleteSpecialization(id);
   	}
   	
  //Create specialization
   	@PostMapping("/specializations")
   	public Specialization createSpecialization(@RequestBody Specialization specialization) {
   		
   		return specializationService.createSpecialization(specialization);
   	}
	
}
