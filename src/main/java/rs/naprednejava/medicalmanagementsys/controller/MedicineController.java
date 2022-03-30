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
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.repository.MedicineRepository;
import rs.naprednejava.medicalmanagementsys.service.MedicineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MedicineController {

	@Autowired
    private MedicineService medicineService;
    
    //Get all medicines
    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineService.getAllMedicine();
    }
	
    //Create medicine
 	@PostMapping("/medicines")
 	public Medicine createMedicine(@RequestBody Medicine medicine) {
 		return medicineService.createMedicine(medicine);
 	}
 	
 	//Get medicine by id
 	@GetMapping("/medicines/{id}")
 	public ResponseEntity<Medicine> getEmployeeById(@PathVariable Long id) {
 		return medicineService.getEmployeeById(id);
 	}
 	
 	//Update medicine
 	@PutMapping("/medicines/{id}")
 	public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails){
 		return medicineService.updateMedicine(id, medicineDetails);
 	}
 	
 	//Delete medicine
 	@DeleteMapping("/medicines/{id}")
 	public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable Long id){
 		return medicineService.deleteMedicine(id);
 	}
    
}
