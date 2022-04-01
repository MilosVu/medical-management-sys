package rs.naprednejava.medicalmanagementsys.model;

import java.time.LocalTime;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity(name="Examination")
@Table(name = "examination")
public class Examination{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examination_id")
	private Long examinationId;
	
	@Column(name = "doctor_user_id")
	private Long doctorId;

	@Column(name = "patient_user_id")
    private Long patientId;
	
	@ManyToOne
    @MapsId("doctorId")
	private Doctor doctor;

    @ManyToOne
    @MapsId("patientId")
    private Patient patient;
    
    @Column(name = "status_completed")
    private boolean statusCompleted;
    
    @Column(name = "date_of_examination")
    private GregorianCalendar dateOfExamination;
    
	public GregorianCalendar getDateOfExamination() {
		return dateOfExamination;
	}

	public void setDateOfExamination(GregorianCalendar dateOfExamination) {
		this.dateOfExamination = dateOfExamination;
	}

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
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
	
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	
	

	
	

	

	public boolean isStatusCompleted() {
		return statusCompleted;
	}

	public void setStatusCompleted(boolean statusCompleted) {
		this.statusCompleted = statusCompleted;
	}

	public Examination() {
		super();
	}

	public Examination(Long doctorId, Long patientId, Doctor doctor, Patient patient,
			boolean statusCompleted, GregorianCalendar dateOfExamination) {
		super();
		this.doctorId = doctor.getUserId();
		this.patientId = patient.getUserId();
		this.doctor = doctor;
		this.patient = patient;
		this.statusCompleted = statusCompleted;
		
		this.dateOfExamination = dateOfExamination;
	}
	
	public Examination(Long examinationId, Long doctorId, Long patientId, Doctor doctor, Patient patient,
			boolean statusCompleted, GregorianCalendar dateOfExamination) {
		super();
		this.examinationId = examinationId;
		this.doctorId = doctor.getUserId();
		this.patientId = patient.getUserId();
		this.doctor = doctor;
		this.patient = patient;
		this.statusCompleted = statusCompleted;
		
		this.dateOfExamination = dateOfExamination;
	}

	public Examination(Long examinationId, Doctor doctor, Patient patient,
			boolean statusCompleted, GregorianCalendar dateOfExamination) {
		super();
		this.examinationId = examinationId;
		this.doctorId = doctor.getUserId();
		this.patientId = patient.getUserId();
		this.doctor = doctor;
		this.patient = patient;
		this.statusCompleted = statusCompleted;
		
		this.dateOfExamination = dateOfExamination;
	}
	
	@Override
	public String toString() {
		return "Examination [examinationId=" + examinationId + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", doctor=" + doctor + ", patient=" + patient + ", status=" + statusCompleted + ", userCanceled="
				+ ", doctorCanceled=" + ", dateOfExamination=" + dateOfExamination
				+ "]";
	}
	
	 
}
