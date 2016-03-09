package bootcamp.topic5.morphia;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity("courses")
public class Course extends Base{
	
	private String name;
	@Embedded
	private Teacher assigned_teacher;
	private int hours_by_week;
	@Embedded
	private List<Schedule> schedule_time;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Teacher getAssigned_teacher() {
		return assigned_teacher;
	}
	
	public void setAssigned_teacher(Teacher assigned_teacher) {
		this.assigned_teacher = assigned_teacher;
	}
	
	public int getHours_by_week() {
		return hours_by_week;
	}
	
	public void setHours_by_week(int hours_by_week) {
		this.hours_by_week = hours_by_week;
	}
	
	public List<Schedule> getSchedule_time() {
		return schedule_time;
	}
	
	public void setSchedule_time(List<Schedule> schedule_time) {
		this.schedule_time = schedule_time;
	}
	
	
}
