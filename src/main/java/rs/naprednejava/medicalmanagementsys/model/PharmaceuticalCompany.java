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
    private Long company_id;
    
    @Column(name = "name")
    private String name;

	public Long getCompanyId() {
		return company_id;
	}

	public void setCompanyId(Long company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PharmaceuticalCompany(Long company_id, String name) {
		super();
		this.company_id = company_id;
		this.name = name;
	}
	
	public PharmaceuticalCompany(String name) {
		super();
		this.name = name;
	}

	public PharmaceuticalCompany() {
		super();
	}
    
}
