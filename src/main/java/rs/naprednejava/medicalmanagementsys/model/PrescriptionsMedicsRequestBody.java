package rs.naprednejava.medicalmanagementsys.model;

import java.util.List;

public class PrescriptionsMedicsRequestBody {

	private Prescription prescription;
	
	private List<Medicine> medicines;

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public PrescriptionsMedicsRequestBody(Prescription prescription, List<Medicine> medicines) {
		super();
		this.prescription = prescription;
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "PrescriptionsMedicsRequestBody [prescription=" + prescription + ", medicines=" + medicines + "]";
	}
	
}
