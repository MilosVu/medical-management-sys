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
	private int specializationId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "graduated")
	private String graduated;

	public Specialization(int specializationId, String name, String graduated) {
		super();
		this.specializationId = specializationId;
		this.name = name;
		this.graduated = graduated;
	}

	public Specialization() {
		super();
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
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
	
	
	
}
