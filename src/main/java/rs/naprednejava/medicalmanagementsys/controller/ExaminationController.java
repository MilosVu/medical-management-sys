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
import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.repository.ExaminationRepository;
import rs.naprednejava.medicalmanagementsys.service.ExaminationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ExaminationController {

	@Autowired
    private ExaminationService examinationService;
    
    //Get all examinations
    @GetMapping("/examinations")
    public List<Examination> getAllExaminations(){
        return examinationService.getAllExaminations();
    }
    
    //Get all examinations for specified doctor
    @GetMapping("/examinations/doctor/{id}")
    public List<Examination> getAllExaminationsForDoctor(@PathVariable Long id){
    	return examinationService.getAllExaminationsForDoctor(id);
    }
    
    //Get all examinations for specified patient
    @GetMapping("/examinations/patient/{id}")
    public List<Examination> getAllExaminationsForPatient(@PathVariable Long id){
    	return examinationService.getAllExaminationsForPatient(id);
    }

    //Create examination
 	@PostMapping("/examinations")
 	public Examination createExamination(@RequestBody Examination examination) {
 		return examinationService.createExamination(examination); 
 	}
 	
 	//Get examination by id
 	@GetMapping("/examinations/{id}")
 	public ResponseEntity<Examination> getEmployeeById(@PathVariable Long id) {
 		return examinationService.getEmployeeById(id);
 	}
 	
 	//Delete examination
 	 	@DeleteMapping("/examinations/{id}")
 	 	public ResponseEntity<Map<String, Boolean>> deleteExamination(@PathVariable Long id){
 	 		return examinationService.deleteExamination(id);
 	 	}
 	
 	
}
