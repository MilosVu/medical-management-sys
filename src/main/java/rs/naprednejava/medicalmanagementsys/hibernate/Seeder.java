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
import rs.naprednejava.medicalmanagementsys.model.Specialization;
import rs.naprednejava.medicalmanagementsys.model.User;

public class Seeder {
	
	public static void main(String[] args) {

		Specialization specialization1 = new Specialization(1L, "Dermatologists", "Faculty of Medicine - University of Belgrade");
		Specialization specialization2 = new Specialization(2L, "Cardiology", "Faculty of Medicine - University of Belgrade");
		Specialization specialization3 = new Specialization(3L, "Radiology", "Faculty of Medicine - University of Belgrade");
		
		Doctor doctor1 = new Doctor(1L, "Milos", "Vujic", "MilosVu", "milos123", "milos@gmail.com", 60, specialization3);
		Doctor doctor2 = new Doctor(2L, "Mylah", "Mccormick", "MylahMc", "mylah123", "mylah@gmail.com", 50, specialization2);
		Doctor doctor3 = new Doctor(3L, "Jackson", "Frame", "JacksonFr", "jackson123", "jackson@gmail.com", 20, specialization1);
		Doctor doctor4 = new Doctor(4L, "Amanda", "Nichols", "AmandaNi", "amandaNi123", "amanda@gmail.com", 40, specialization1);
		
		Patient patient1 = new Patient(5L, "Dusan", "Gajic", "DusanGa", "dusan123", "dusan@gmail.com", "0653421231", "Penicilin", "male");
		Patient patient2 = new Patient(6L, "Mathilda", "Farley", "MathildaFa", "mathilda123", "mathilda@gmail.com", "061322512", "Penicilin", "female");
		Patient patient3 = new Patient(7L, "Ieuan", "Mason", "IeuanMa", "ieuan123", "ieuan@gmail.com", "065342412321", "Penicilin", "male");
		Patient patient4 = new Patient(8L, "Ameer", "Humphrey", "AmeerHu", "ameer123", "Ameer@gmail.com", "062413215", "Penicilin", "male");
		Patient patient5 = new Patient(9L, "Saba", "Whelan", "SabaWh", "saba123", "saba@gmail.com", "062142351", "Penicilin", "female");
		
		User receptionist1 = new User(10L, "admin", "admin", "admin", "admin", "admin@gmail.com", "receptionist");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* 
		 * 1. Transaction
		 * */
		session.beginTransaction();
	
		/* ======== Specializations ======== */
		session.save(specialization1);
		session.save(specialization2);
		session.save(specialization3);
		
		/* ======== Doctors ======== */
		Long d1Id = (Long) session.save(doctor1);
		Long d2Id = (Long) session.save(doctor2);
		Long d3Id = (Long) session.save(doctor3);
		Long d4Id = (Long) session.save(doctor4);
		
		/* ======== Patients ======== */
		Long p1Id = (Long) session.save(patient1);
		Long p2Id = (Long) session.save(patient2);
		Long p3Id = (Long) session.save(patient3);
		Long p4Id = (Long) session.save(patient4);
		Long p5Id = (Long) session.save(patient5);

		/* ======== Receptionists ======== */
		session.save(receptionist1);
		
		/* ======== Examinations ======== */
		Examination examination1 = new Examination(1L, new Doctor(d1Id), new Patient(p1Id), false, false, false, new GregorianCalendar());
		Examination examination2 = new Examination(1L, new Doctor(d1Id), new Patient(p3Id), false, false, false, new GregorianCalendar());
		Examination examination3 = new Examination(1L, new Doctor(d2Id), new Patient(p1Id), false, false, false, new GregorianCalendar());
		Examination examination4 = new Examination(1L, new Doctor(d2Id), new Patient(p2Id), false, false, false, new GregorianCalendar());
		Examination examination5 = new Examination(1L, new Doctor(d2Id), new Patient(p3Id), false, false, false, new GregorianCalendar());
		Examination examination6 = new Examination(1L, new Doctor(d3Id), new Patient(p1Id), false, false, false, new GregorianCalendar());
		Examination examination7 = new Examination(1L, new Doctor(d3Id), new Patient(p4Id), false, false, false, new GregorianCalendar());
		Examination examination8 = new Examination(1L, new Doctor(d3Id), new Patient(p2Id), false, false, false, new GregorianCalendar());
		Examination examination9 = new Examination(1L, new Doctor(d3Id), new Patient(p3Id), false, false, false, new GregorianCalendar());
		Examination examination10 = new Examination(1L, new Doctor(d3Id), new Patient(p5Id), false, false, false, new GregorianCalendar());
		Examination examination11 = new Examination(1L, new Doctor(d4Id), new Patient(p5Id), false, false, false, new GregorianCalendar());
		
		session.save(examination1);
		session.save(examination2);
		session.save(examination3);
		session.save(examination4);
		session.save(examination5);
		session.save(examination6);
		session.save(examination7);
		session.save(examination8);
		session.save(examination9);
		session.save(examination10);
		session.save(examination11);
		
		
		session.getTransaction().commit();
		
		/* 2. Transaction */
		
	
//		session.beginTransaction();
//		
//		
//		session.getTransaction().commit();
		
	}

}
