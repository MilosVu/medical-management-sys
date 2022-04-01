package rs.naprednejava.medicalmanagementsys.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Embeddable
public class PrescriptionMedicineId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @MapsId("prescriptionId")
	private Prescription prescription;
	
    @ManyToOne
    @MapsId("medicineId")
    private Medicine medicine;

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public PrescriptionMedicineId(Prescription prescription, Medicine medicine) {
		super();
		this.prescription = prescription;
		this.medicine = medicine;
	}

	public PrescriptionMedicineId() {
		super();
	}

}
