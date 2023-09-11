package org.hibernate.dto;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query ;

public class FetchPersonByAge {

	public static void main(String[] args) {
		
		String jpql = "select p from Person p where p.age=?1";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter age to fetch the person");
		int age = s.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q =  manager.createQuery(jpql);
		q.setParameter(1,age);
		List<Person> ps = q.getResultList();
		
		if(ps.size()>0) {
			for(Person p :ps) {
			System.out.println("id :" + p.getId());
			System.out.println("name : " + p.getName());
			System.out.println("age : " + p.getAge());
			System.out.println("phone number : " + p.getPhone());
			System.out.println("Email Id : " + p.getEmail());
			}
		}
		else
			System.err.println("No person found with the entered age ");

	}

}
