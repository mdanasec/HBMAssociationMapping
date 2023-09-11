package org.hibernate.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FindPersonById {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter id to find a record");
		int id =s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);
		
		if(p!=null) {
			System.out.println("id :" + p.getId());
			System.out.println("age :" + p.getAge());
			System.out.println("name :" + p.getName());
			System.out.println("phone :" + p.getPhone());
			System.out.println("email :" + p.getEmail());
			
		}
		else
			System.err.println("you have entered an invalid id !!");
	}
}
