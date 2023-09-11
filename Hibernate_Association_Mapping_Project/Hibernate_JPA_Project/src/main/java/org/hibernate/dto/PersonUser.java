package org.hibernate.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonUser {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setName("Shad");
		p.setAge(22);
		p.setPhone(758186894l);
		p.setEmail("Shad@gmail.com.com");
		p.setPassword("Shad@123");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		manager.persist(p);
		
		EntityTransaction tranction = manager.getTransaction();
		tranction.begin();
		tranction.commit();
		System.out.println("person save with is :" + p.getId());
	}

}
