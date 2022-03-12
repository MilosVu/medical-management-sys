package rs.naprednejava.medicalmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.naprednejava.medicalmanagementsys.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

}
