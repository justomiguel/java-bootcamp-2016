package database;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Course {

	@Id
	private ObjectId id;
	
	private String courseName;
	private int hoursWeek;
	@Embedded
	private ArrayList<CourseSchedule> schedule;
	@Embedded
	private Teacher teacherAssigned;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String courseName, int hoursWeek,
			ArrayList<CourseSchedule> schedule, Teacher teacherAssigned) {
		this.courseName = courseName;
		this.hoursWeek = hoursWeek;
		this.schedule = schedule;
		this.teacherAssigned = teacherAssigned;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getHoursWeek() {
		return hoursWeek;
	}
	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public ArrayList<CourseSchedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<CourseSchedule> schedule) {
		this.schedule = schedule;
	}
	public Teacher getTeacherAssigned() {
		return teacherAssigned;
	}
	public void setTeacherAssigned(Teacher teacherAssigned) {
		this.teacherAssigned = teacherAssigned;
	}
	
	
}
