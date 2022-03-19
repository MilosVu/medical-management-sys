package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.Examination;
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
	
}
