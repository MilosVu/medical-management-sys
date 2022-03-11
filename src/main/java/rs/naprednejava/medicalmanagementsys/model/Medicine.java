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
	private int medicineid;
	
	@Column(name = "name")
	private String name;

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medicine(int medicineid, String name) {
		this.medicineid = medicineid;
		this.name = name;
	}

	public Medicine() {
	}
	
	
	
}
