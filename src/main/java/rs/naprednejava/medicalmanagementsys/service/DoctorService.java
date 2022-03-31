package rs.naprednejava.medicalmanagementsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
    private DoctorRepository doctorRepository;
    
    
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    
    
 	public Doctor createDoctor(Doctor doctor) {
    	doctor.setUserRole("doctor");
 		return doctorRepository.save(doctor);
 	}
    
    
    
 	public ResponseEntity<Doctor> getUsersById(String id) {
    	Doctor doctor = doctorRepository.findById(Long.parseLong(id))
 				.orElseThrow(() -> new ResourceNotFoundException("Doctor does not exist with id :" + id));
 		return ResponseEntity.ok(doctor);
 	}
	
}
