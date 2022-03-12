package rs.naprednejava.medicalmanagementsys.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rs.naprednejava.medicalmanagementsys.model.Medicine;

public class Seeder {
	
	public static void main(String[] args) {
		
		Medicine m1 = new Medicine();
		m1.setName("TestSeeder");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(m1);
		session.getTransaction().commit();
	}

}
