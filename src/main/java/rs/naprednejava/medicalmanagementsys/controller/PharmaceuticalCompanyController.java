package rs.naprednejava.medicalmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.repository.PharmaceuticalCompanyRepository;

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
	
}
