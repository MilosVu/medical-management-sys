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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SpecializationController {

	@Autowired
    private SpecializationRepository specializationRepository;
    
    //Get all specializations
    @GetMapping("/specializations")
    public List<Specialization> getAllSpecializations(){
        return specializationRepository.findAll();
    }
    
	//Get specialization by id
   	@GetMapping("/specializations/{id}")
   	public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {
   		Specialization specialization = specializationRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Specialization does not exist with id :" + id));
   		return ResponseEntity.ok(specialization);
   	}
   	
  //Delete specializations
   	@DeleteMapping("/specializations/{id}")
   	public ResponseEntity<Map<String, Boolean>> deleteSpecialization(@PathVariable Long id){
   		Specialization specialization = specializationRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Specialization does not exist with id :" + id));
   		
   		specializationRepository.delete(specialization);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
   	
  //Create specialization
   	@PostMapping("/specializations")
   	public Specialization createSpecialization(@RequestBody Specialization specialization) {
   		
   		return specializationRepository.save(specialization);
   	}
	
}
