package com.topic5.app;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class CourseList corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class CourseList {
	
	@Id
	private ObjectId id;
		
	private int partialNote1;
	private int partialNote2;
	private int partialNote3;
	private double finalNote;
	
	@Embedded
	private Course course;
	
	@Embedded
	private Student student;
	
	/**
	 *Constructor of CourseList class
	 */
	public CourseList (){
		
	}

	/**
	 *Constructor of CourseList class
	 *@param course type Course, used to set the course attribute
	 *@param student type Student, used to set the student attribute
	 *@param partialNote1 type int, used to set the first partial note attribute
	 *@param partialNote2 type int, used to set the second partial note attribute
	 *@param partialNote3 type int, used to set the third partial note attribute
	 *@param finalNote type double, used to set the final note attribute
	 */
	public CourseList(Course course, Student student,int partialNote1, int partialNote2, int partialNote3, double finalNote) {
		this.partialNote1 = partialNote1;
		this.partialNote2 = partialNote2;
		this.partialNote3 = partialNote3;
		this.finalNote = finalNote;
		this.course = course;
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public ObjectId getId() {
		return id;
	}
	
		
	public int getPartialNote1() {
		return partialNote1;
	}

	public int getPartialNote2() {
		return partialNote2;
	}

	public int getPartialNote3() {
		return partialNote3;
	}

	public double getFinalNote() {
		return finalNote;
	}


}
