package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.repository.MedicineRepository;

@RestController
@RequestMapping("/api/v1/")
public class MedicineController {

	@Autowired
    private MedicineRepository medicineRepository;
    
    //Get all users
    @GetMapping("/medicines")
    public List<Medicine> getAllUsers(){
        return medicineRepository.findAll();
    }
	
}
