package bootcamp.topic5.morphia;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Schedule {
	private int day;
	private String hour_in;
	private String hour_out;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getHour_in() {
		return hour_in;
	}
	public void setHour_in(String hour_in) {
		this.hour_in = hour_in;
	}
	public String getHour_out() {
		return hour_out;
	}
	public void setHour_out(String hour_out) {
		this.hour_out = hour_out;
	}
}
