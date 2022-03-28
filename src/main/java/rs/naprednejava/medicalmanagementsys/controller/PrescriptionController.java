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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.Prescription;
import rs.naprednejava.medicalmanagementsys.repository.PharmaceuticalCompanyRepository;
import rs.naprednejava.medicalmanagementsys.repository.PrescriptionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PrescriptionController {

	
	@Autowired
    private PrescriptionRepository prescriptionRepository;
    
    //Get all prescriptions
    @GetMapping("/prescriptions")
    public List<Prescription> getAllPrescriptions(){
        return prescriptionRepository.findAll();
    }
    
    //Create prescription
   	@PostMapping("/prescriptions")
   	public Prescription createPrescription(@RequestBody Prescription prescription) {
   		return prescriptionRepository.save(prescription);
   	}
   	
   	//Get prescription by id
   	@GetMapping("/prescriptions/{id}")
   	public ResponseEntity<Prescription> getPrescriptionId(@PathVariable Long id) {
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		return ResponseEntity.ok(prescription);
   	}
   	
   	//Update Prescription 
   	@PutMapping("/prescriptions/{id}")
   	public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails){
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		
   		
   		prescription.setDisease(prescriptionDetails.getDisease());

   		
   		Prescription updatedPrescription = prescriptionRepository.save(prescription);
   		return ResponseEntity.ok(updatedPrescription);
   	}
   	
   	//Delete prescription
   	@DeleteMapping("/prescriptions/{id}")
   	public ResponseEntity<Map<String, Boolean>> deletePrescription(@PathVariable Long id){
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		
   		prescriptionRepository.delete(prescription);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
}
