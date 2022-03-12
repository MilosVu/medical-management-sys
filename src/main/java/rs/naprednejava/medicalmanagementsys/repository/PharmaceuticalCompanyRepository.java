package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;

@Repository
public interface PharmaceuticalCompanyRepository extends JpaRepository<PharmaceuticalCompany, Long>{

}
