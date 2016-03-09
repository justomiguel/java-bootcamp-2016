package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class Student corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class Student extends BaseEntity{
	
	@Id
	private ObjectId registrationNumber;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	/**
	 *Constructor of Student class
	 */
	public Student () {
		
	}
	
	/**
	 *Constructor of Student class
	 *@param firstName type String, used to set the first name attribute
	 *@param lastName type String, used to set the last name attribute
	 *@param dateOfBirth type String, used to set the date of birth attribute
	 */
	public Student(String firstName, String lastName,String dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public ObjectId getRegistrationNumber() {
		return registrationNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateBirth() {
		return dateOfBirth;
	}
	public void setDateBirth(String string) {
		this.dateOfBirth = string;
	}
}
