package bootcamp.topic5.morphia;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity("notes")
public class Note extends Base {
	
	@Reference
	private Course course_id;
	@Embedded
	private Student student;
	private List<Integer> partial_notes;	
	private int final_note;
	
	public List<Integer> getPartial_notes() {
		return partial_notes;
	}
	
	public void setPartial_notes(List<Integer> partial_notes) {
		this.partial_notes = partial_notes;
	}
	
	public int getFinal_note() {
		return final_note;
	}
	
	public void setFinal_note(int final_note) {
		this.final_note = final_note;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
