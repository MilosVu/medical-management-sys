package rs.naprednejava.medicalmanagementsys.controller;

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

import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionMedicine;
import rs.naprednejava.medicalmanagementsys.service.PharmaceuticalCompanyService;
import rs.naprednejava.medicalmanagementsys.service.PrescriptionMedicineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PrescriptionMedicineController {

	@Autowired
    private PrescriptionMedicineService prescriptionMedicineService;
    
    //Get all PrescriptionMedicineService
    @GetMapping("/prescription-medicines")
    public List<PrescriptionMedicine> getAllPrescriptionMedicines(){
        return prescriptionMedicineService.getAllPrescriptionMedicines();
    }
    
    //Create PrescriptionMedicineService
   	@PostMapping("/prescription-medicines")
   	public PrescriptionMedicine createPrescriptionMedicine(@RequestBody PrescriptionMedicine prescriptionMedicine) {
   		return prescriptionMedicineService.createPrescriptionMedicine(prescriptionMedicine);
   	}
   	
   	//Get PrescriptionMedicineService by id
   	@GetMapping("/prescription-medicines/{id}")
   	public ResponseEntity<PrescriptionMedicine> getPrescriptionMedicineById(@PathVariable Long id) {
   		return prescriptionMedicineService.getPrescriptionMedicineById(id);
   	}
   	
   	//Update PrescriptionMedicineService
   	@PutMapping("/prescription-medicines/{id}")
   	public ResponseEntity<PrescriptionMedicine> updatePrescriptionMedicine(@PathVariable Long id, @RequestBody PrescriptionMedicine prescriptionMedicineDetails){
   		return prescriptionMedicineService.updatePrescriptionMedicine(id, prescriptionMedicineDetails);
   	}
   	
   	//Delete PrescriptionMedicineService
   	@DeleteMapping("/prescription-medicines/{id}")
   	public ResponseEntity<Map<String, Boolean>> deletePrescriptionMedicine(@PathVariable Long id){
   		return prescriptionMedicineService.deletePrescriptionMedicine(id);
   	}
}
