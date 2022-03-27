package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialization")
public class Specialization {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long specialization_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "graduated")
	private String graduated;

	public Specialization(Long specialization_id, String name, String graduated) {
		super();
		this.specialization_id = specialization_id;
		this.name = name;
		this.graduated = graduated;
	}

	public Specialization() {
		super();
	}

	public Long getSpecializationId() {
		return specialization_id;
	}

	public void setSpecializationId(Long specialization_id) {
		this.specialization_id = specialization_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGraduated() {
		return graduated;
	}

	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}

	@Override
	public String toString() {
		return "Specialization [specialization_id=" + specialization_id + ", name=" + name + ", graduated=" + graduated
				+ "]";
	}
	
	
	
}
