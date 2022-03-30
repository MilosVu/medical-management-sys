package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "prescription")
public class Prescription {


	
	@OneToOne	
	@JoinColumn(name="examination_id", insertable = false, updatable = false)
	@MapsId("examinationId")
	private Examination examination;
	
	@Id
	@Column(name="prescriptionId")
	private long prescriptionId;
	
	@Column(name = "examination_id")
	private Long examinationId;

	
	public String disease;
	
	public String description;
	
	public Prescription(Examination examination, long prescriptionId, Long examinationId, String disease,
			String description) {
		super();
		this.examination = examination;
		this.prescriptionId = prescriptionId;
		this.examinationId = examinationId;
		this.disease = disease;
		this.description = description;
	}

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}

	

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Prescription(Examination examination, long prescriptionId, String disease) {
		super();
		
		this.examination = examination;
		this.prescriptionId = prescriptionId;
		this.disease = disease;
	}

	public Prescription() {
		super();
	}
	
	
	
}
