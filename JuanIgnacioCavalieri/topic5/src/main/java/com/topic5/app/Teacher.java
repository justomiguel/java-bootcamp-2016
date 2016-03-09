package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class Teacher corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class Teacher {

	@Id
	private ObjectId dni;
		
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	/**
	 *Constructor of Teacher class
	 */
	public Teacher (){
		
	}
		
	/**
	 *Constructor of Teacher class
	 *@param firstName type String, used to set the first name attribute
	 *@param lastName type String, used to set the last name attribute
	 *@param dateOfBirth type String, used to set the date of birth attribute
	 */
	public Teacher(String firstName, String lastName, String dateOfBirth) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public ObjectId getId() {
		return dni;
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
		
}
