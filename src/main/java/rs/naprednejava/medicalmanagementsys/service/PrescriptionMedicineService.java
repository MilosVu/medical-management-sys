package rs.naprednejava.medicalmanagementsys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionMedicine;
import rs.naprednejava.medicalmanagementsys.repository.PharmaceuticalCompanyRepository;
import rs.naprednejava.medicalmanagementsys.repository.PrescriptionMedicineRepository;
@Service
public class PrescriptionMedicineService {

	
	@Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;
    
    
    public List<PrescriptionMedicine> getAllPrescriptionMedicines(){
        return prescriptionMedicineRepository.findAll();
    }
    
    
   	public PrescriptionMedicine createPrescriptionMedicine(PrescriptionMedicine prescriptionMedicine) {
   		return prescriptionMedicineRepository.save(prescriptionMedicine);
   	}
   	
   	
   	public ResponseEntity<PrescriptionMedicine> getPrescriptionMedicineById(Long id) {
   		PrescriptionMedicine prescriptionMedicine = prescriptionMedicineRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PrescriptionMedicine does not exist with id :" + id));
   		return ResponseEntity.ok(prescriptionMedicine);
   	}
   	
   	
   	public ResponseEntity<PrescriptionMedicine> updatePrescriptionMedicine(Long id, @RequestBody PrescriptionMedicine prescriptionMedicineDetails){
   		PrescriptionMedicine prescriptionMedicine= prescriptionMedicineRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PrescriptionMedicine does not exist with id :" + id));
   		
   		
   		//prescriptionMedicine.setName(prescriptionMedicineDetails.getName());

   		
   		PrescriptionMedicine updatedPrescriptionMedicine = prescriptionMedicineRepository.save(prescriptionMedicine);
   		return ResponseEntity.ok(updatedPrescriptionMedicine);
   	}
   	
   	
   	public ResponseEntity<Map<String, Boolean>> deletePrescriptionMedicine(Long id){
   		PrescriptionMedicine prescriptionMedicine = prescriptionMedicineRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PrescriptionMedicine does not exist with id :" + id));
   		
   		prescriptionMedicineRepository.delete(prescriptionMedicine);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
}
