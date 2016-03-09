package database;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class StudentNotes {

	@Id
	private ObjectId id;
	
	private int note1;
	private int note2;
	private int note3;
	private int finalNote;
	@Embedded
	private Course course;
	@Embedded
	private Student student;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentNotes() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentNotes(int note1, int note2, int note3,
			int finalNote, Course course, Student student) {
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.finalNote = finalNote;
		this.course = course;
		this.student = student;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getNote1() {
		return note1;
	}
	public void setNote1(int note1) {
		this.note1 = note1;
	}
	public int getNote2() {
		return note2;
	}
	public void setNote2(int note2) {
		this.note2 = note2;
	}
	public int getNote3() {
		return note3;
	}
	public void setNote3(int note3) {
		this.note3 = note3;
	}
	public int getFinalNote() {
		return finalNote;
	}
	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}
	
}
