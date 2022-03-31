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
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
    private MedicineRepository medicineRepository;
    
    
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }
	
    
 	public Medicine createMedicine(Medicine medicine) {
 		medicine.setMedicineid(0L);
 		return medicineRepository.save(medicine);
 	}
 	
 	
 	public ResponseEntity<Medicine> getEmployeeById(Long id) {
 		Medicine medicine = medicineRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Medicine does not exist with id :" + id));
 		return ResponseEntity.ok(medicine);
 	}
 	
 	
 	public ResponseEntity<Medicine> updateMedicine(Long id, Medicine medicineDetails){
 		Medicine medicine = medicineRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Medicine does not exist with id :" + id));
 		
 		
 		medicine.setName(medicineDetails.getName());

 		
 		Medicine updatedMedicine = medicineRepository.save(medicine);
 		return ResponseEntity.ok(updatedMedicine);
 	}
 	
 	
 	public ResponseEntity<Map<String, Boolean>> deleteMedicine(Long id){
 		Medicine medicine = medicineRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Medicine does not exist with id :" + id));
 		
 		medicineRepository.delete(medicine);
 		Map<String, Boolean> response = new HashMap<>();
 		response.put("deleted", Boolean.TRUE);
 		return ResponseEntity.ok(response);
 	}
}
