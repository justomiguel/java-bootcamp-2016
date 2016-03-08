package bootcamp.topic5.morphia;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Teacher extends Base {
	private String first_name;
	private String last_name;
	private Date birth_date;
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public Date getBirth_date() {
		return birth_date;
	}
	
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
}
