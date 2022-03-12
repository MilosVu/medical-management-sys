package rs.naprednejava.medicalmanagementsys.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "examination")
public class Examination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
    @JoinColumn(name = "doctorid")
	private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean status;
    
    @Column(name = "usercanceled")
    private boolean userCanceled;
    
    @Column(name = "doctorcanceled")
    private boolean doctorCanceled;

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isUserCanceled() {
		return userCanceled;
	}

	public void setUserCanceled(boolean userCanceled) {
		this.userCanceled = userCanceled;
	}

	public boolean isDoctorCanceled() {
		return doctorCanceled;
	}

	public void setDoctorCanceled(boolean doctorCanceled) {
		this.doctorCanceled = doctorCanceled;
	}

	public Examination(Doctor doctor, Patient patient, boolean status,
			boolean userCanceled, boolean doctorCanceled) {
		super();
		
		this.doctor = doctor;
		this.patient = patient;
		this.status = status;
		this.userCanceled = userCanceled;
		this.doctorCanceled = doctorCanceled;
	}

	public Examination() {
		super();
	}
    
    
}
