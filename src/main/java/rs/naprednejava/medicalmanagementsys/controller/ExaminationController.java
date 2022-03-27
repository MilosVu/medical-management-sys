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
import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.model.User;
import rs.naprednejava.medicalmanagementsys.repository.ExaminationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ExaminationController {

	@Autowired
    private ExaminationRepository examinationRepository;
    
    //Get all examinations
    @GetMapping("/examinations")
    public List<Examination> getAllExaminations(){
        return examinationRepository.findAll();
    }
    
    //Get all examinations for specified doctor
    @GetMapping("/examinations/doctor/{id}")
    public List<Examination> getAllExaminationsForDoctor(@PathVariable Long id){
    	Doctor d = new Doctor();
    	d.setUserId(id);
        return examinationRepository.findByDoctor(d);
    }
    
    //Get all examinations for specified patient
    @GetMapping("/examinations/patient/{id}")
    public List<Examination> getAllExaminationsForPatient(@PathVariable Long id){
    	Patient p = new Patient();
    	p.setUserId(id);
        return examinationRepository.findByPatient(p);
    }

    //Create examination
 	@PostMapping("/examinations")
 	public Examination createExamination(@RequestBody Examination examination) {
 		examination.setDoctorId(examination.getDoctor().getUserId());
 		examination.setPatientId(examination.getPatient().getUserId());
 		return examinationRepository.save(examination);
 	}
 	
 	//Get examination by id
 	@GetMapping("/examinations/{id}")
 	public ResponseEntity<Examination> getEmployeeById(@PathVariable Long id) {
 		Examination examination = examinationRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Examination does not exist with parameters"));
 		return ResponseEntity.ok(examination);
 	}
 	
 	
}
