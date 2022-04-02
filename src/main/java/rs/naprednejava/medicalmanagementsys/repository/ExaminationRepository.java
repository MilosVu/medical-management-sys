package rs.naprednejava.medicalmanagementsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Patient;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long>{

	List<Examination> findByDoctorOrderByDateOfExaminationAsc(Doctor doctor);

	List<Examination> findByPatientOrderByDateOfExaminationAsc(Patient p);
	
	List<Examination> findByStatusCompleted(boolean statusCompleted);

}
