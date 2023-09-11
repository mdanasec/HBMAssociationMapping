package org.hibernate.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePerson {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the person id to delete the record ");
		int id = s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Person p = manager.find(Person.class, id);
		if(p!=null) {
			manager.remove(p);
			
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
		}
		else 
			System.err.println("you have entered an invalid id !!");
	}
}
