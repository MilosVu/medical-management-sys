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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Prescription;
import rs.naprednejava.medicalmanagementsys.repository.ExaminationRepository;
import rs.naprednejava.medicalmanagementsys.repository.PrescriptionMedicineRepository;
import rs.naprednejava.medicalmanagementsys.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	
	@Autowired
    private PrescriptionRepository prescriptionRepository;
	@Autowired
    private ExaminationRepository examinationRepository;
	@Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;
   
    public List<Prescription> getAllPrescriptions(){
        return prescriptionRepository.findAll();
    }
    
    
   	public Prescription createPrescription(Prescription prescription) {
   		prescription.setExaminationId(prescription.getExamination().getExaminationId());
   		
   		Examination examination= prescription.getExamination();
   		examination.setStatus(true);
   		
   		examinationRepository.save(examination);
 		
   		return prescriptionRepository.save(prescription);
   	}
   	
  
   	public ResponseEntity<Prescription> getPrescriptionId(Long id) {
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		return ResponseEntity.ok(prescription);
   	}
   	
   	
   	public ResponseEntity<Prescription> updatePrescription(Long id, Prescription prescriptionDetails){
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		
   		
   		prescription.setDisease(prescriptionDetails.getDisease());

   		
   		Prescription updatedPrescription = prescriptionRepository.save(prescription);
   		return ResponseEntity.ok(updatedPrescription);
   	}
   	
   	
   	public ResponseEntity<Map<String, Boolean>> deletePrescription(Long id){
   		Prescription prescription = prescriptionRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("Prescription does not exist with id :" + id));
   		
   		prescriptionRepository.delete(prescription);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
}
