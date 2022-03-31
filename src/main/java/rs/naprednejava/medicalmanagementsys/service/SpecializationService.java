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
import rs.naprednejava.medicalmanagementsys.model.Specialization;
import rs.naprednejava.medicalmanagementsys.repository.SpecializationRepository;

@Service
public class SpecializationService {
	@Autowired
    private SpecializationRepository specializationRepository;
    
    
    public List<Specialization> getAllSpecializations(){
        return specializationRepository.findAll();
    }
    
	
   	public ResponseEntity<Specialization> getSpecializationById(Long id) {
   		Specialization specialization = specializationRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Specialization does not exist with id :" + id));
   		return ResponseEntity.ok(specialization);
   	}
   	
  
   	public ResponseEntity<Map<String, Boolean>> deleteSpecialization(Long id){
   		Specialization specialization = specializationRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Specialization does not exist with id :" + id));
   		
   		specializationRepository.delete(specialization);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
   	
  
   	public Specialization createSpecialization(Specialization specialization) {
   		
   		return specializationRepository.save(specialization);
   	}
}
