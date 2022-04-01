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
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.repository.ExaminationRepository;

@Service
public class ExaminationService {

	@Autowired
    private ExaminationRepository examinationRepository;
    
    
    public List<Examination> getAllExaminations(){
        return examinationRepository.findAll();
    }
    
    
    public List<Examination> getAllExaminationsForDoctor(Long id){
    	Doctor d = new Doctor();
    	d.setUserId(id);
        return examinationRepository.findByDoctor(d);
    }
    
    
    public List<Examination> getAllExaminationsForPatient(Long id){
    	Patient p = new Patient();
    	p.setUserId(id);
        return examinationRepository.findByPatient(p);
    }

    
 	public Examination createExamination(Examination examination) {
 		examination.setDoctorId(examination.getDoctor().getUserId());
 		examination.setPatientId(examination.getPatient().getUserId());
 		return examinationRepository.save(examination);
 	}
 	
 	
 	public ResponseEntity<Examination> getExaminationById(Long id) {
 		Examination examination = examinationRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Examination does not exist with parameters"));
 		return ResponseEntity.ok(examination);
 	}
 	
 	public List<Examination> getCompletedExaminations() {
 		return examinationRepository.findByStatusCompleted(true);
 	}

 	public ResponseEntity<Map<String, Boolean>> deleteExamination(Long id){
 		Examination examination = examinationRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Examination does not exist with id :" + id));
 	 		
 	 	examinationRepository.delete(examination);
 	 	Map<String, Boolean> response = new HashMap<>();
 	 	response.put("deleted", Boolean.TRUE);
 	 	return ResponseEntity.ok(response);
 	}
}
