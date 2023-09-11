package org.hibernate.dto;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VarifyByEmailName {

	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("varifyByEmailName");

		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Email Id ");
		String email = s.next();
		System.out.println("Enter a Name");
		String name = s.next();

		q.setParameter(1, email);
		q.setParameter(2, name);
		List<Person> ps = q.getResultList();

		if (ps.size() > 0) {
			for (Person p : ps) {

				System.out.println("id : " + p.getId());
				System.out.println("name : " + p.getName());
				System.out.println("age : " + p.getAge());
				System.out.println("phone number : " + p.getPhone());
				System.out.println("Email Id : " + p.getEmail());
				System.out.println("----------------------------------");

			}
		} else
			System.err.println("you have entered invalid number!!");
	}
}
