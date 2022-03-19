package rs.naprednejava.medicalmanagementsys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExaminationId implements Serializable{
	
	@Column(name="doctorid")
	private Long doctorId;
	
	@Column(name="patientid")
	private Long patientId;

	public ExaminationId(Long doctorId, Long patientId) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

	public ExaminationId() {
		super();
	}
	
	
}
