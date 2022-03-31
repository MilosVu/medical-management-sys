package rs.naprednejava.medicalmanagementsys.model;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name="PrescriptionMedicine")
@Table(name = "prescriptionMedicine")
public class PrescriptionMedicine {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescriptionMedicine_id")
	private Long prescriptionMedicineId;
	
	
	@ManyToOne
    @MapsId("prescriptionId")
	private Prescription prescription;
	
    @ManyToOne
    @MapsId("medicineId")
    private Medicine medicine;
    
    

	public Long getPrescriptionMedicineId() {
		return prescriptionMedicineId;
	}

	public void setPrescriptionMedicineId(Long prescriptionMedicineId) {
		this.prescriptionMedicineId = prescriptionMedicineId;
	}

	

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

	public PrescriptionMedicine(Long prescriptionMedicineId, Prescription prescription, Medicine medicine) {
		super();
		
		this.prescriptionMedicineId = prescriptionMedicineId;
		this.prescription = prescription;
		this.medicine = medicine;
	}

	public PrescriptionMedicine(Prescription prescription, Medicine medicine) {
		super();
		
		this.prescription = prescription;
		this.medicine = medicine;
	}
	
	public PrescriptionMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}
    
   
    
}
