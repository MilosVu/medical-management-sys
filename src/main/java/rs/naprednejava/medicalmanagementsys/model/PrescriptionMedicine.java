package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "prescription_medicine")
public class PrescriptionMedicine {

	@EmbeddedId
	private PrescriptionMedicineId prescriptionMedicineId;

	public PrescriptionMedicineId getPrescriptionMedicineId() {
		return prescriptionMedicineId;
	}

	public void setPrescriptionMedicineId(PrescriptionMedicineId prescriptionMedicineId) {
		this.prescriptionMedicineId = prescriptionMedicineId;
	}

	public PrescriptionMedicine(PrescriptionMedicineId prescriptionMedicineId) {
		super();
		this.prescriptionMedicineId = prescriptionMedicineId;
	}
	
	public PrescriptionMedicine() {
		super();
	}
	
//	@ManyToOne
//    @MapsId("prescriptionId")
//	private Prescription prescription;
//	
//    @ManyToOne
//    @MapsId("medicineId")
//    private Medicine medicine;
//   
//	
//	public Prescription getPrescription() {
//		return prescription;
//	}
//
//	public void setPrescription(Prescription prescription) {
//		this.prescription = prescription;
//	}
//
//	public Medicine getMedicine() {
//		return medicine;
//	}
//
//	public void setMedicine(Medicine medicine) {
//		this.medicine = medicine;
//	}
//
//	public PrescriptionMedicine(Long prescriptionId, Long medicineId, Prescription prescription, Medicine medicine) {
//		super();
//		this.prescriptionMedicineId = new PrescriptionMedicineId(prescriptionId, medicineId);
//		this.prescription = prescription;
//		this.medicine = medicine;
//	}
//
//	public PrescriptionMedicine() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
    
   
    
}
