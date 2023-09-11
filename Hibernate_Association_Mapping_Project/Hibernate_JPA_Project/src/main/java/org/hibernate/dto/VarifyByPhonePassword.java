package org.hibernate.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VarifyByPhonePassword {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("varifyByPhone");
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter a phone number to varify person");
		long phone =s.nextLong();
		System.out.println("Enter a Password ");
		String password = s.next();
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		
		try {
			Person p = (Person)q.getSingleResult();
			System.out.println("id : " + p.getId());
			System.out.println("name : " + p.getName());
			System.out.println("age : " + p.getAge());
			System.out.println("phone :" + p.getPhone());
			System.out.println("Email Id : " + p.getEmail());
			
		} catch (NoResultException e) {
			System.err.println("invalid phone number or password ");
		}

	}

}




















