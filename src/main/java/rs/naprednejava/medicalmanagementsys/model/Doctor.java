package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import java.util.ArrayList;
import java.util.Set;


@Entity(name="Doctor")
@Table(name="doctor")
public class Doctor extends User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    
    @Column(name = "fees")
    private double fees;
    
    @OneToMany(mappedBy = "doctor",
    		cascade = CascadeType.ALL)
    private java.util.List<Examination> examination = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")
    private Specialization specialization;
    
	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long user_id) {
		this.user_id = user_id;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Specialization getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	
	public Doctor() {
		super();
	}

	public Doctor(Long user_id, String firstName, String lastName, String username,String email, String password,
			double fees, Specialization specialization) {
		super(user_id, firstName, lastName, username, email, password, "doctor");
		this.user_id = user_id;
		this.fees = fees;
		this.specialization = specialization;
	}
	
	public Doctor(String firstName, String lastName, String username,String email, String password,
			double fees, Specialization specialization) {
		super( firstName, lastName, username, email, password, "doctor");
		this.user_id = user_id;
		this.fees = fees;
		this.specialization = specialization;
	}

	public Doctor(Long user_id) {
		super(user_id);
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Doctor [user_id=" + user_id + ", fees=" + fees + ", specialization="
				+ specialization + "]";
	}
	
	

}
