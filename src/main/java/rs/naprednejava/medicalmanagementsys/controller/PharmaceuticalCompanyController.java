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
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.repository.PharmaceuticalCompanyRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PharmaceuticalCompanyController {

	@Autowired
    private PharmaceuticalCompanyRepository pharmaceuticalCompanyRepository;
    
    //Get all pharmaceutical companies
    @GetMapping("/pharmaceutical-company")
    public List<PharmaceuticalCompany> getAllPharmaceuticalCompanies(){
        return pharmaceuticalCompanyRepository.findAll();
    }
    
    //Create pharmaceutical company
   	@PostMapping("/pharmaceutical-company")
   	public PharmaceuticalCompany createPharmaceuticalCompany(@RequestBody PharmaceuticalCompany pharmaceuticalCompany) {
   		return pharmaceuticalCompanyRepository.save(pharmaceuticalCompany);
   	}
   	
   	//Get pharmaceutical company by id
   	@GetMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<PharmaceuticalCompany> getEmployeeById(@PathVariable Long id) {
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		return ResponseEntity.ok(pharmaceuticalCompany);
   	}
   	
   	//Update pharmaceutical company
   	@PutMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<PharmaceuticalCompany> updatePharmaceuticalCompany(@PathVariable Long id, @RequestBody PharmaceuticalCompany pharmaceuticalCompanyDetails){
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		
   		
   		pharmaceuticalCompany.setName(pharmaceuticalCompanyDetails.getName());

   		
   		PharmaceuticalCompany updatedPharmaceuticalCompany = pharmaceuticalCompanyRepository.save(pharmaceuticalCompany);
   		return ResponseEntity.ok(updatedPharmaceuticalCompany);
   	}
   	
   	//Delete pharmaceutical company
   	@DeleteMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<Map<String, Boolean>> deletePharmaceuticalCompany(@PathVariable Long id){
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		
   		pharmaceuticalCompanyRepository.delete(pharmaceuticalCompany);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
	
}
