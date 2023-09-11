package org.hibernate.dto;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {

	public static void main(String[] args) {

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner s = new Scanner(System.in);
		System.out.println("enter the person name to fetch the person");
		String name = s.next();
		Query q = manager.createNamedQuery("findByName");
		q.setParameter(1, name);
		List<Person> ps = q.getResultList();

		if (ps.size() > 0) {
			for (Person p : ps) {
				System.out.println("id :" + p.getId());
				System.out.println("name : " + p.getName());
				System.out.println("age : " + p.getAge());
				System.out.println("phone number : " + p.getPhone());
				System.out.println("Email Id : " + p.getEmail());
			}
		} else
			System.err.println("No person found with the entered age ");

	}

}
