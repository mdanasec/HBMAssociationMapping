package org.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "findByName", query = "select p from Person p where p.name=?1")

@NamedQueries(value = {
		@NamedQuery(name = "varifyById", query = "select p from Person p where p.id=?1 and p.password=?2 "),
		@NamedQuery(name = "varifyByPhone", query = "select p from Person p where p.phone=?1 and p.password=?2 "),
		@NamedQuery(name = "varifyByPhoneNumber", query = "select p from Person p where p.phone=?1"),
		@NamedQuery(name = "varifyByEmail", query = "select p from Person p where p.email=?1 and p.password=?2 "),
		@NamedQuery(name = "varifyByIdName", query = "select p from Person p where p.id=?1 and p.name=?2 "),
		@NamedQuery(name = "varifyByAgeName", query = "select p from Person p where p.age=?1 and p.name=?2 "),
		@NamedQuery(name = "varifyByPhoneName", query = "select p from Person p where p.phone=?1 and p.name=?2 "),
		@NamedQuery(name = "varifyByEmailPassword", query = "select p from Person p where p.email=?1 and p.password=?2 "),
		@NamedQuery(name = "varifyByEmailName", query = "select p from Person p where p.email=?1 and p.name=?2 "),
		})

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(nullable = false)

	private String name;
	@Column(nullable = false)

	private int age;
	@Column(nullable = false)

	private long phone;
	@Column(nullable = false, unique = true)

	private String email;
	@Column(nullable = false, unique = true)

	private String password;

	public Person(int id, String name, int age, long phone, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
