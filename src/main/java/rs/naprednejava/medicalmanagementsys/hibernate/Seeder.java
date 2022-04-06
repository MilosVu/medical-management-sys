package rs.naprednejava.medicalmanagementsys.hibernate;

import java.io.Serializable;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rs.naprednejava.medicalmanagementsys.model.Doctor;
import rs.naprednejava.medicalmanagementsys.model.Examination;
import rs.naprednejava.medicalmanagementsys.model.Medicine;
import rs.naprednejava.medicalmanagementsys.model.Patient;
import rs.naprednejava.medicalmanagementsys.model.PharmaceuticalCompany;
import rs.naprednejava.medicalmanagementsys.model.Prescription;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionMedicine;
import rs.naprednejava.medicalmanagementsys.model.PrescriptionMedicineId;
import rs.naprednejava.medicalmanagementsys.model.Specialization;
import rs.naprednejava.medicalmanagementsys.model.User;

public class Seeder {
	
	public static void main(String[] args) {

		Specialization specialization1 = new Specialization(1L, "Dermatologists", "Faculty of Medicine - University of Belgrade");
		Specialization specialization2 = new Specialization(2L, "Cardiology", "Faculty of Medicine - Johns Hopkins University, USA");
		Specialization specialization3 = new Specialization(3L, "Radiology", "Faculty of Medicine - Columbia University, USA");
		Specialization specialization4 = new Specialization(4L, "Sports medicine", "Faculty of Medicine - University of Belgrade");
		
		Doctor doctor1 = new Doctor(1L, "Milos", "Vujic", "MilosVu", "milos123", "milos@gmail.com", 60, specialization3);
		Doctor doctor2 = new Doctor(2L, "Mylah", "Mccormick", "MylahMc", "mylah123", "mylah@gmail.com", 50, specialization2);
		Doctor doctor3 = new Doctor(3L, "Jackson", "Frame", "JacksonFr", "jackson123", "jackson@gmail.com", 20, specialization1);
		Doctor doctor4 = new Doctor(4L, "Jack", "Frostman", "JackFr", "jack123", "jack@gmail.com", 35, specialization1);
		Doctor doctor5 = new Doctor(5L, "Emilia", "Vo", "EmiliaVo", "emilia123", "emilia@gmail.com", 25, specialization4);
		Doctor doctor6 = new Doctor(6L, "Hammad", "Sanderson", "HammadSa", "hammad123", "hammad@gmail.com", 40, specialization4);
		Doctor doctor7 = new Doctor(7L, "Lamar", "Nichols", "LamarMo", "lamar123", "lamar@gmail.com", 55, specialization4);
		Doctor doctor8 = new Doctor(8L, "Inigo", "Ferreira", "InigoFe", "inigo123", "inigo@gmail.com", 50, specialization2);
		Doctor doctor9 = new Doctor(9L, "Tayla", "Bradley", "TaylaBr", "tayla123", "tayla@gmail.com", 40, specialization3);
		Doctor doctor10 = new Doctor(10L, "Harvey-Lee", "Welch", "HarveyWe", "harvey123", "harvey@gmail.com", 20, specialization1);
		
		Patient patient1 = new Patient(5L, "Dusan", "Gajic", "DusanGa", "dusan123", "dusan@gmail.com", "0653421231", "Penicilin", "male");
		Patient patient2 = new Patient(6L, "Mathilda", "Farley", "MathildaFa", "mathilda123", "mathilda@gmail.com", "061322512", "Aspirin", "female");
		Patient patient3 = new Patient(7L, "Ieuan", "Mason", "IeuanMa", "ieuan123", "ieuan@gmail.com", "065342412321", "Ibuprofen", "male");
		Patient patient4 = new Patient(8L, "Ameer", "Humphrey", "AmeerHu", "ameer123", "Ameer@gmail.com", "062413215", "Omeprazole", "male");
		Patient patient5 = new Patient(9L, "Saba", "Whelan", "SabaWh", "saba123", "saba@gmail.com", "062142351", "Metoprolol", "female");
		
		User receptionist1 = new User(10L, "admin", "admin", "admin", "admin", "admin@gmail.com", "receptionist");
		
		PharmaceuticalCompany pharmaceuticacomany1 = new PharmaceuticalCompany("Novartis");
		PharmaceuticalCompany pharmaceuticacomany2 = new PharmaceuticalCompany("Pfizer");
		PharmaceuticalCompany pharmaceuticacomany3 = new PharmaceuticalCompany("Johnson & Johnson");
		
		
		Medicine medicine1 = new Medicine("Amoxicillin", pharmaceuticacomany1);
		Medicine medicine2 = new Medicine("Lisinopril", pharmaceuticacomany2);
		Medicine medicine3 = new Medicine("Levothyroxine", pharmaceuticacomany2);
		Medicine medicine4 = new Medicine("Metoprolol", pharmaceuticacomany2);
		Medicine medicine5 = new Medicine("Atorvastatin", pharmaceuticacomany3);
		Medicine medicine6 = new Medicine("Metformin", pharmaceuticacomany2);
		Medicine medicine7 = new Medicine("Omeprazole", pharmaceuticacomany1);
		Medicine medicine8 = new Medicine("Losartan", pharmaceuticacomany1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* 
		 * 1. Transaction
		 * */
		session.beginTransaction();
		
		/* ======== Pharmaceutical Companies ======== */
		session.save(specialization1);
		session.save(specialization2);
		session.save(specialization3);
		
		/* ======== Medicines ======== */
		Long medicine1Id = (Long) session.save(medicine1);
		Long medicine2Id = (Long) session.save(medicine2);
		Long medicine3Id = (Long) session.save(medicine3);
		Long medicine4Id = (Long) session.save(medicine4);
		Long medicine5Id = (Long) session.save(medicine5);
		Long medicine6Id = (Long) session.save(medicine6);
		Long medicine7Id = (Long) session.save(medicine7);
		Long medicine8Id = (Long) session.save(medicine8);
	
		/* ======== Specializations ======== */
		session.save(specialization1);
		session.save(specialization2);
		session.save(specialization3);
		session.save(specialization4);
		
		/* ======== Doctors ======== */
		Long d1Id = (Long) session.save(doctor1);
		Long d2Id = (Long) session.save(doctor2);
		Long d3Id = (Long) session.save(doctor3);
		Long d4Id = (Long) session.save(doctor4);
		Long d5Id = (Long) session.save(doctor5);
		Long d6Id = (Long) session.save(doctor6);
		Long d7Id = (Long) session.save(doctor7);
		Long d8Id = (Long) session.save(doctor8);
		Long d9Id = (Long) session.save(doctor9);
		Long d10Id = (Long) session.save(doctor10);
		
		/* ======== Patients ======== */
		Long p1Id = (Long) session.save(patient1);
		Long p2Id = (Long) session.save(patient2);
		Long p3Id = (Long) session.save(patient3);
		Long p4Id = (Long) session.save(patient4);
		Long p5Id = (Long) session.save(patient5);

		/* ======== Receptionists ======== */
		session.save(receptionist1);
		
		/* ======== Examinations ======== */
		Examination examination1 = new Examination(1L, new Doctor(d1Id), new Patient(p1Id), false, 
				new GregorianCalendar(2022, 4, 6, 9, 30));
		Examination examination2 = new Examination(1L, new Doctor(d1Id), new Patient(p3Id), false, 
				new GregorianCalendar(2022, 4, 6, 10, 30));
		Examination examination3 = new Examination(1L, new Doctor(d1Id), new Patient(p2Id), false, 
				new GregorianCalendar(2022, 4, 6, 11, 00));
		Examination examination4 = new Examination(1L, new Doctor(d1Id), new Patient(p4Id), false, 
				new GregorianCalendar(2022, 4, 6, 12, 30));
		Examination examination5 = new Examination(1L, new Doctor(d1Id), new Patient(p5Id), false, 
				new GregorianCalendar(2022, 4, 6, 13, 00));
		Examination examination6 = new Examination(1L, new Doctor(d1Id), new Patient(p1Id), false, 
				new GregorianCalendar(2022, 4, 6, 13, 30));
		Examination examination7 = new Examination(1L, new Doctor(d1Id), new Patient(p4Id), false, 
				new GregorianCalendar(2022, 4, 6, 10, 30));
		Examination examination8 = new Examination(1L, new Doctor(d1Id), new Patient(p2Id), false, 
				new GregorianCalendar(2022, 4, 6, 9, 30));
		Examination examination9 = new Examination(1L, new Doctor(d1Id), new Patient(p3Id), false, 
				new GregorianCalendar(2022, 4, 7, 12, 30));
		Examination examination10 = new Examination(1L, new Doctor(d1Id), new Patient(p5Id), false, 
				new GregorianCalendar(2022, 4, 7, 15, 00));
		Examination examination11 = new Examination(1L, new Doctor(d1Id), new Patient(p5Id), false, 
				new GregorianCalendar(2022, 4, 7, 16, 00));
		
		
		Long exa1Id = (Long) session.save(examination1);
		Long exa2Id = (Long) session.save(examination2);
		session.save(examination3);
		session.save(examination4);
		session.save(examination5);
		session.save(examination6);
		session.save(examination7);
		session.save(examination8);
		session.save(examination9);
		session.save(examination10);
		session.save(examination11);
		
		
		Prescription prescription1 = new Prescription(examination1, exa1Id, "bolest1", "gotov si nema ti spasa");
		Prescription prescription2 = new Prescription(examination2, exa2Id, "bolest2", "gotov si nema ti spasa ponovo");
		
		session.save(prescription1);
		session.save(prescription2);
		
		PrescriptionMedicine prescriptionMedicine1 = new PrescriptionMedicine(new PrescriptionMedicineId(prescription1, medicine1));
		PrescriptionMedicine prescriptionMedicine2 = new PrescriptionMedicine(new PrescriptionMedicineId(prescription1, medicine2));
		PrescriptionMedicine prescriptionMedicine3 = new PrescriptionMedicine(new PrescriptionMedicineId(prescription2, medicine5));
		
		session.save(prescriptionMedicine1);
		session.save(prescriptionMedicine2);
		session.save(prescriptionMedicine3);
		
		session.getTransaction().commit();
		
	}

}
