package database;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Student extends BaseEntity{
	@Id
	private ObjectId id;
	private String firstName;
	private String lastName;
	private int registrationNumber;
	private String dateBirth;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String firstName, String lastName, int registrationNumber,
			String dateBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNumber = registrationNumber;
		this.dateBirth = dateBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String string) {
		this.dateBirth = string;
	}
	
}
