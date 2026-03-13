package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.klef.fsad.exam.Product;

//import jakarta.transaction.Transaction;

//import java.util.Date;

public class ClientDemo {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
		        .configure("hibernate.cfg.xml")
		        .buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Product p = new Product();

		p.setName("Laptop");
		p.setDescription("Dell Laptop");
		p.setStatus("Available");
		p.setDate("2024-05-06");

		session.persist(p);

		tx.commit();
		session.close();

		System.out.println("Record Inserted");

		Session session2 = sf.openSession();
		tx = session2.beginTransaction();

		Product pr = session2.get(Product.class, 1);

		pr.setStatus("Sold");

		session2.update(pr);

		tx.commit();
		session2.close();

		System.out.println("Record Updated");

	}
}