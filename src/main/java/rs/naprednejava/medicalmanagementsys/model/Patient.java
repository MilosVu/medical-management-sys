package rs.naprednejava.medicalmanagementsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "userid")
public class Patient extends User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "allergies")
	private String allergies;
	
	@Column(name = "gender")
	private String gender;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Patient(int userid, String firstName, String lastName, String username, String password, int userid2,
			String contact, String allergies, String gender) {
		super(userid, firstName, lastName, username, password);
		userid = userid2;
		this.contact = contact;
		this.allergies = allergies;
		this.gender = gender;
	}

	public Patient(int userid, String firstName, String lastName, String username, String password) {
		super(userid, firstName, lastName, username, password);
	}

	public Patient(int userid, String contact, String allergies, String gender) {
		this.userid = userid;
		this.contact = contact;
		this.allergies = allergies;
		this.gender = gender;
	}
    
	public Patient() {
		super();
	}
	
}
