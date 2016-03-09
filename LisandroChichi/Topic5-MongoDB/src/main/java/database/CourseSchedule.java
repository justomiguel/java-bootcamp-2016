package database;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class CourseSchedule {
	
	@Id
	private ObjectId id;
	
	private String day;
	private String hour;
	
	public CourseSchedule() {
		// TODO Auto-generated constructor stub
	}
	
	public CourseSchedule(String day, String hour) {
		this.day = day;
		this.hour = hour;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	
	
}
