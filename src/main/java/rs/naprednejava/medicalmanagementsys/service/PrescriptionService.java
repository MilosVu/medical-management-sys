package rs.naprednejava.medicalmanagementsys.service;

import java.util.ArrayList;
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
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.model.Prescription;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionMedicine;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionsMedicsRequestBody;
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
    
    
    public List<Prescription> getAllPrescriptionsByPatient(Long id){
    	List<Prescription> prescriptions = new ArrayList<>();
    	List<Examination> examinations = examinationRepository.findByPatient( new Patient(id) );
    	
    	for (Examination examination : examinations) {
			
    		Prescription p = prescriptionRepository.getByExamination(examination);
    		if(p != null) {
    			prescriptions.add(p);
    		}
		}
    	
    	return prescriptions;
    }
    
    
   	public Prescription createPrescription(PrescriptionsMedicsRequestBody request) {
   		System.out.println(request);

//   		Examination examination = (request.getPrescription()).getExamination();
//   		examination.setStatusCompleted(true);
//   		
//   		examinationRepository.save(examination);
//   		
//   		request.getPrescription().setPrescriptionId(32);
//   		
//   		Prescription p = (Prescription) prescriptionRepository.save(request.getPrescription());
//   		
//   		List<PrescriptionMedicine> listPrescriptionMedicines = new ArrayList<>();
//   		
//   		for (Medicine m : request.getMedicines()) {
//			PrescriptionMedicine prescriptionMedicine = new PrescriptionMedicine(p.getExaminationId(), m.getMedicineid() ,p, m);
//			listPrescriptionMedicines.add(prescriptionMedicine);
//			
//		}
//   		
//   		prescriptionMedicineRepository.saveAll(listPrescriptionMedicines);
//
//   		return p;
   		return null;
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
