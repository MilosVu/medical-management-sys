package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
