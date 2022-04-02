package rs.naprednejava.medicalmanagementsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

	Prescription getByExamination(Examination examination);
	
}
