package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineid;
	
	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    private PharmaceuticalCompany pharmaceuticalCompany;
	
	public Long getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(Long medicineid) {
		this.medicineid = medicineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public PharmaceuticalCompany getPharmaceuticalCompany() {
		return pharmaceuticalCompany;
	}

	public void setName(PharmaceuticalCompany pharmaceuticalCompany) {
		this.pharmaceuticalCompany = pharmaceuticalCompany;
	}

	public Medicine(Long medicineid, String name, PharmaceuticalCompany pharmaceuticalCompany) {
		this.medicineid = medicineid;
		this.name = name;
		this.pharmaceuticalCompany = pharmaceuticalCompany;
	}

	public Medicine() {
	}
	
	
	
}
