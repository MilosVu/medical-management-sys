package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pharmaceuticalcompany")
public class PharmaceuticalCompany {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    
    @Column(name = "name")
    private double name;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public double getName() {
		return name;
	}

	public void setName(double name) {
		this.name = name;
	}

	public PharmaceuticalCompany(Long companyId, double name) {
		super();
		this.companyId = companyId;
		this.name = name;
	}

	public PharmaceuticalCompany() {
		super();
	}
    
}
