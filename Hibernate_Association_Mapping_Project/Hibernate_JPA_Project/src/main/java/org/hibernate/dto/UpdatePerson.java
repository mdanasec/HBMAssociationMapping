package org.hibernate.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatePerson {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter a person Id :");
		int id = s.nextInt();

		Person p = new Person();
//		System.out.println("Enter name, age, phone, email and password to update");

		p.setId(id);
		System.out.println("age");
		p.setAge(s.nextInt());
		
		System.out.println("name");
		p.setName(s.next());
		
		System.out.println("phone");
		p.setPhone(s.nextLong());
		
		System.out.println("email");
		p.setEmail(s.next());
		
		System.out.println("password");
		p.setPassword(s.next());

		EntityManagerFactory f = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = f.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(p);
		transaction.begin();
		transaction.commit();
		System.out.println("Person Updated ");

	}

}
