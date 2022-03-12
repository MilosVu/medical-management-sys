package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineid;
	
	@Column(name = "name")
	private String name;

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

	public Medicine(Long medicineid, String name) {
		this.medicineid = medicineid;
		this.name = name;
	}

	public Medicine() {
	}
	
	
	
}
