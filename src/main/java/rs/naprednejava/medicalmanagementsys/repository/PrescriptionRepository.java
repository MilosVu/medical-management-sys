package rs.naprednejava.medicalmanagementsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
<<<<<<< HEAD

	Prescription getByExamination(Examination examination);
	
=======
	public Prescription findByExaminationId(Long examinationId);
>>>>>>> c23f2a6d1b838e87da156a1baae57b05d04e4336
}
