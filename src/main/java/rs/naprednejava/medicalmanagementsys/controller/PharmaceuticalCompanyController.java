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
import rs.naprednejava.medicalmanagementsys.service.PharmaceuticalCompanyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PharmaceuticalCompanyController {

	@Autowired
    private PharmaceuticalCompanyService pharmaceuticalCompanyService;
    
    //Get all pharmaceutical companies
    @GetMapping("/pharmaceutical-company")
    public List<PharmaceuticalCompany> getAllPharmaceuticalCompanies(){
        return pharmaceuticalCompanyService.getAllPharmaceuticalCompanies();
    }
    
    //Create pharmaceutical company
   	@PostMapping("/pharmaceutical-company")
   	public PharmaceuticalCompany createPharmaceuticalCompany(@RequestBody PharmaceuticalCompany pharmaceuticalCompany) {
   		return pharmaceuticalCompanyService.createPharmaceuticalCompany(pharmaceuticalCompany);
   	}
   	
   	//Get pharmaceutical company by id
   	@GetMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<PharmaceuticalCompany> getCompanyById(@PathVariable Long id) {
   		return pharmaceuticalCompanyService.getCompanyById(id);
   	}
   	
   	//Update pharmaceutical company
   	@PutMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<PharmaceuticalCompany> updatePharmaceuticalCompany(@PathVariable Long id, @RequestBody PharmaceuticalCompany pharmaceuticalCompanyDetails){
   		return pharmaceuticalCompanyService.updatePharmaceuticalCompany(id, pharmaceuticalCompanyDetails);
   	}
   	
   	//Delete pharmaceutical company
   	@DeleteMapping("/pharmaceutical-company/{id}")
   	public ResponseEntity<Map<String, Boolean>> deletePharmaceuticalCompany(@PathVariable Long id){
   		return pharmaceuticalCompanyService.deletePharmaceuticalCompany(id);
   	}
	
}
