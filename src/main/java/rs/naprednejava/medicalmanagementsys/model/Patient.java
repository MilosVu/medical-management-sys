package rs.naprednejava.medicalmanagementsys.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="Patient")
@Table(name="patient")
public class Patient extends User{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "allergies")
	private String allergies;
	
	@Column(name = "gender")
	private String gender;
	
	

//	@OneToMany(mappedBy = "patient")
//    Set<Examination> examination;
	
	
	@OneToMany(mappedBy = "patient",
    		cascade = CascadeType.ALL)
    private List<Examination> examination=new ArrayList<>();
	
	
	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long user_id) {
		this.user_id = user_id;
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

//	public Set<Examination> getExamination() {
//		return examination;
//	}
  
	public Patient(Long user_id, String firstName, String lastName, String username, String email, String password, 
			String contact, String allergies, String gender) {
		super(user_id, firstName, lastName, username, email, password, "patient");
		this.user_id = user_id;
		this.contact = contact;
		this.allergies = allergies;
		this.gender = gender;
		
	}
	
	public Patient(String firstName, String lastName, String username,String email, String password,
			String contact, String allergies, String gender) {
		super( firstName, lastName, username, email, password, "patient");
		this.contact = contact;
		this.allergies = allergies;
		this.gender = gender;
	}
	
	public Patient(Long user_id) {
		super(user_id);
		this.user_id = user_id;
	}
	
	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return " Patient [user_id=" + user_id + ", contact=" + contact + ", allergies=" + allergies + ", gender=" + gender
				+ "]";
	}
	
}
