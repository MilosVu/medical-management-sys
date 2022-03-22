package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.model.User;
import rs.naprednejava.medicalmanagementsys.repository.ExaminationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ExaminationController {

	@Autowired
    private ExaminationRepository examinationRepository;
    
    //Get all users
    @GetMapping("/examinations")
    public List<Examination> getAllExaminations(){
        return examinationRepository.findAll();
    }
    
    @GetMapping("/examinations/doctor/{id}")
    public List<Examination> getAllExaminationsForDoctor(@PathVariable Long id){
    	Doctor d = new Doctor();
    	d.setUserid(id);
        return examinationRepository.findByDoctor(d);
    }
    
    @GetMapping("/examinations/patient/{id}")
    public List<Examination> getAllExaminationsForPatient(@PathVariable Long id){
    	Patient p = new Patient();
    	p.setUserid(id);
        return examinationRepository.findByPatient(p);
    }
	
}
