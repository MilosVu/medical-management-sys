package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
