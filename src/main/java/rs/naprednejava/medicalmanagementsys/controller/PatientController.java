package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.repository.PatientRepository;
import rs.naprednejava.medicalmanagementsys.service.PatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {

	@Autowired
    private PatientService patientService;
    
    //Get all users
    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
	
    @PostMapping("/patients")
 	public Patient createPatient(@RequestBody Patient patient) {
    	return patientService.createPatient(patient);
 	}
    
}
