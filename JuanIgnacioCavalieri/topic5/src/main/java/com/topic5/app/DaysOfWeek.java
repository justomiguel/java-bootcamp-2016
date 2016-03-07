package com.topic5.app;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *Class DaysOfWeek corresponding to the Topic 5 of Java bootcamp
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
@Entity
public class DaysOfWeek {
	
	@Id
	private int id;
	
	private String name;
	
	/**
	 *Constructor of Teacher class
	 *@param id type int, used to set the object id
	 *@param name type String, used to set the name attribute
	 */
	public DaysOfWeek (int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId (){
		return id;
	}
	
	public String getName (){
		return name;
	}
}
