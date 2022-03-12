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
import java.util.Set;


@Entity
@PrimaryKeyJoinColumn(name = "userid")
public class Doctor extends User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    
    @Column(name = "fees")
    private double fees;
    
//    @OneToMany(mappedBy = "doctor")
//    Set<Examination> examination;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specializationId", referencedColumnName = "specializationId")
    private Specialization specialization;
    
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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
	
//	public Set<Examination> getExamination() {
//		return examination;
//	}

	public Doctor() {
		super();
	}

	public Doctor(Long userid, String firstName, String lastName, String username, String password,
			double fees, Specialization specialization) {
		super(userid, firstName, lastName, username, password);
		this.userid = userid;
		this.fees = fees;
		this.specialization = specialization;
	}


}
