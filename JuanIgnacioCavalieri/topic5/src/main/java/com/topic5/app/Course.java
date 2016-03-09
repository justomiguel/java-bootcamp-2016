package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class Course corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class Course {

	@Id
	private ObjectId id;
	
	private String courseName;
	private int hoursByWeek;
	
	@Embedded
	private Teacher assignedTeacher;
	
	/**
	 *Constructor of Course class
	 */
	public Course (){
		
	}
	
	/**
	 *Constructor of Course class
	 *@param courseName type String, used to set the name of the course
	 *@param hoursByWeek type int, used to sed the hours of the course on a week
	 *@param assignedTeacher type Teacher, used to set the assigned teacher of the course
	 */
	public Course(String courseName, int hoursByWeek, Teacher assignedTeacher) {
		this.courseName = courseName;
		this.hoursByWeek = hoursByWeek;
		this.assignedTeacher = assignedTeacher;
	}
	
	public ObjectId getID() {
		return id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getHoursByWeek() {
		return hoursByWeek;
	}
	
	public Teacher getAssignedTeacher() {
		return assignedTeacher;
	}
	


	
	
}
