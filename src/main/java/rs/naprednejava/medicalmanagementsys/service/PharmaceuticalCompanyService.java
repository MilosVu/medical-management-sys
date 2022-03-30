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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rs.naprednejava.medicalmanagementsys.exception.ResourceNotFoundException;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.repository.PharmaceuticalCompanyRepository;

@Service
public class PharmaceuticalCompanyService {

	@Autowired
    private PharmaceuticalCompanyRepository pharmaceuticalCompanyRepository;
    
    
    public List<PharmaceuticalCompany> getAllPharmaceuticalCompanies(){
        return pharmaceuticalCompanyRepository.findAll();
    }
    
    
   	public PharmaceuticalCompany createPharmaceuticalCompany(PharmaceuticalCompany pharmaceuticalCompany) {
   		return pharmaceuticalCompanyRepository.save(pharmaceuticalCompany);
   	}
   	
   	
   	public ResponseEntity<PharmaceuticalCompany> getCompanyById(Long id) {
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		return ResponseEntity.ok(pharmaceuticalCompany);
   	}
   	
   	
   	public ResponseEntity<PharmaceuticalCompany> updatePharmaceuticalCompany(Long id, @RequestBody PharmaceuticalCompany pharmaceuticalCompanyDetails){
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		
   		
   		pharmaceuticalCompany.setName(pharmaceuticalCompanyDetails.getName());

   		
   		PharmaceuticalCompany updatedPharmaceuticalCompany = pharmaceuticalCompanyRepository.save(pharmaceuticalCompany);
   		return ResponseEntity.ok(updatedPharmaceuticalCompany);
   	}
   	
   	
   	public ResponseEntity<Map<String, Boolean>> deletePharmaceuticalCompany(Long id){
   		PharmaceuticalCompany pharmaceuticalCompany = pharmaceuticalCompanyRepository.findById(id)
   				.orElseThrow(() -> new ResourceNotFoundException("PharmaceuticalCompany does not exist with id :" + id));
   		
   		pharmaceuticalCompanyRepository.delete(pharmaceuticalCompany);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return ResponseEntity.ok(response);
   	}
}
