package rs.naprednejava.medicalmanagementsys.model;

import java.time.LocalTime;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity(name="Examination")
@Table(name = "examination")
public class Examination{

	@EmbeddedId
	private ExaminationId id;
	
	@ManyToOne
    @MapsId("doctorid")
	private Doctor doctor;

    @ManyToOne
    @MapsId("patientid")
    private Patient patient;
    
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "usercanceled")
    private boolean userCanceled;
    
    @Column(name = "doctorcanceled")
    private boolean doctorCanceled;

    @Column(name = "dateOfExamination")
    private GregorianCalendar dateOfExamination;
    
    
	
	public Examination(ExaminationId id, Doctor doctor, Patient patient, boolean status, boolean userCanceled,
			boolean doctorCanceled, GregorianCalendar dateOfExamination ) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.status = status;
		this.userCanceled = userCanceled;
		this.doctorCanceled = doctorCanceled;
		this.dateOfExamination = dateOfExamination;
		
	}

	public GregorianCalendar getDateOfExamination() {
		return dateOfExamination;
	}

	public void setDateOfExamination(GregorianCalendar dateOfExamination) {
		this.dateOfExamination = dateOfExamination;
	}


	public ExaminationId getId() {
		return id;
	}

	public void setId(ExaminationId id) {
		this.id = id;
	}

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

	

	public Examination() {
		super();
	}
    
    
}
