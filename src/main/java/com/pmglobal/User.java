package com.pmglobal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="user")
public class User {
	
	@Id 
	private @GeneratedValue int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	private String gender;
	
	private Date date_of_birth;
	
	@Column(name="date_created")
	@CreationTimestamp
	private Date date_created;
	
	
	@Column(name="date_updated")
	@UpdateTimestamp
	private  Date date_updated;
	
	
	public User() {

	}

	public User(int id, String firstname, String lastname, String gender, Date date_of_birth) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_created() {
		return date_created;
	}

	public Date getDate_updated() {
		return date_updated;
	}

	@Override
	public String toString() {
		return "{'id' : '" + id + "', 'firstname' : '" + firstname + "', 'lastname' :'" + lastname + "', 'gender' : '" + gender
				+ "', 'date_of_birth' :'" + date_of_birth + "', 'date_created' :'" + date_created + "', 'date_updated' :'"
				+ date_updated + "'}";
	}
	
	
	
	

}
