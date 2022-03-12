package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long>{

}
