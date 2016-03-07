package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class ClassesOfWeek corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class ClassesOfWeek {
	
	@Id
	private ObjectId id;
		
	@Embedded
	private DaysOfWeek day;
	
	@Embedded
	private Course course;
	
	private String hour;
		
		
	/**
	 *Constructor of ClassesOfWeek class
	 *@param id type int, used to set the ID attribute
	 *@param day type DaysOfWeek, used to set the day of week attribute
	 *@param hour type String, used to set the hour attribute
	 *@param course type Course, used to set course attribute
	 */
	public ClassesOfWeek(int id, DaysOfWeek day, String hour, Course course) {
		this.day = day;
		this.hour = hour;
		this.course = course;
	}
	
	
	public ObjectId getId() {
		return id;
	}

	public DaysOfWeek getDay() {
		return day;
	}

	public String getHour() {
		return hour;
	}
	
	public Course getCourse() {
		return course;
	}


}
