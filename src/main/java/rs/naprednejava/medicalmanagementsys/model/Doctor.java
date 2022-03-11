package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor extends User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    
    @Column(name = "fees")
    private double fees;
    
    @Column(name = "specializationId")
    private int specializationId;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public Doctor() {
		super();
	}

	public Doctor(int userid, double fees, int specializationId, String firstName, String lastName, String username, String password) {
		super(userid, firstName, lastName, username, password);
		this.userid = userid;
		this.fees = fees;
		this.specializationId = specializationId;
	}
    
    
    
	
}
