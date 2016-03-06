package database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MainHighSchool {

	public static void main(String[] args) throws UnknownHostException,
			MongoException {
		// TODO Auto-generated method stub

		String dbName = new String("highSchool");
		Morphia morphia = new Morphia();
		morphia.mapPackage("org.mongodb.morphia.example");

		Datastore data = morphia.createDatastore(new MongoClient(), dbName);

		final Teacher teacherJava = new Teacher("Lisandro", "Chichi",
				"11/01/1980");
		final Teacher teacherPHP = new Teacher("Carlos", "Penzo", "14/02/1981");
		final Teacher teacherNET = new Teacher("Seba", "Lopez", "14/05/1986");

		// Course Schedule
		final CourseSchedule courseSchedule = new CourseSchedule("Monday",
				"09:00 - 11:00");
		final CourseSchedule courseSchedule1 = new CourseSchedule("Monday",
				"15:00 - 17:30");
		final CourseSchedule courseSchedule2 = new CourseSchedule("Friday",
				"10:00 - 14:00");
		final CourseSchedule courseSchedule3 = new CourseSchedule("Tuesday",
				"19:00 - 21:00");
		final CourseSchedule courseSchedule4 = new CourseSchedule("Wednesday",
				"09:00 - 13:00");
		final CourseSchedule courseSchedule5 = new CourseSchedule("Friday",
				"12:00 - 15:30");
		final CourseSchedule courseSchedule6 = new CourseSchedule("Thursday",
				"14:00 - 18:00");
		final CourseSchedule courseSchedule7 = new CourseSchedule("Friday",
				"09:30 - 12:30");

		ArrayList<CourseSchedule> scheduleJava = new ArrayList<CourseSchedule>();
		ArrayList<CourseSchedule> schedulePHP = new ArrayList<CourseSchedule>();
		ArrayList<CourseSchedule> scheduleNET = new ArrayList<CourseSchedule>();

		// schedule for the course Java
		scheduleJava.add(courseSchedule);
		scheduleJava.add(courseSchedule1);
		scheduleJava.add(courseSchedule2);
		// schedule for the course PHP
		schedulePHP.add(courseSchedule3);
		schedulePHP.add(courseSchedule4);
		schedulePHP.add(courseSchedule5);
		// schedule for the course .NET
		scheduleNET.add(courseSchedule6);
		scheduleNET.add(courseSchedule7);

		// COURSES
		final Course courseJava = new Course("Java", 12, scheduleJava,
				teacherJava);
		final Course coursePHP = new Course("PHP", 12, schedulePHP, teacherPHP);
		final Course courseNET = new Course(".NET", 12, scheduleNET, teacherNET);

		final Student student = new Student("Juan", "Perez", 34564,
				"15/03/1990");
		final Student student1 = new Student("alberto", "lopez", 43570,
				"1991-12-11");
		final Student student2 = new Student("julian", "ramirez", 42579,
				"1992-01-01");
		final Student student3 = new Student("santiago", "gutierrez", 23579,
				"1990-07-01");
		final Student student4 = new Student("rodolfo", "beron", 43379,
				"1990-04-21");
		final Student student5 = new Student("antonieto", "cristaldo", 1579,
				"1990-06-11");
		final Student student6 = new Student("ramiro", "dutti", 4319,
				"1990-01-15");
		final Student student7 = new Student("sergio", "hermida", 4353,
				"1990-03-01");
		final Student student8 = new Student("rodrigo", "fages", 43456,
				"1990-03-21");
		final Student student9 = new Student("jose", "jerez", 43079,
				"1990-08-12");
		final Student student10 = new Student("carlos", "llano", 41179,
				"1990-08-14");
		final Student student11 = new Student("juan", "martin", 43569,
				"1990-10-03");
		final Student student12 = new Student("antonio", "nieves", 44089,
				"1990-09-01");
		final Student student13 = new Student("pepe", "ortega", 41119,
				"1990-02-21");
		final Student student14 = new Student("miranda", "palacios", 4279,
				"1990-11-11");
		final Student student15 = new Student("agostina", "donatto", 43544,
				"1990-10-01");
		final Student student16 = new Student("agustin", "martinez", 49863,
				"1990-12-12");
		final Student student17 = new Student("maria", "bou", 54645,
				"1990-12-24");
		final Student student18 = new Student("antonella", "alario", 34234,
				"1990-01-25");
		final Student student19 = new Student("luis", "illia", 45679,
				"1990-09-01");

		final StudentNotes notes1 = new StudentNotes(7, 7, 8, 7, courseJava,
				student);
		final StudentNotes notes2 = new StudentNotes(8, 8, 8, 8, coursePHP,
				student1);
		final StudentNotes notes3 = new StudentNotes(6, 7, 8, 7, courseNET,
				student2);
		final StudentNotes notes4 = new StudentNotes(4, 3, 3, 3, courseJava,
				student3);
		final StudentNotes notes5 = new StudentNotes(5, 8, 9, 7, coursePHP,
				student3);
		final StudentNotes notes6 = new StudentNotes(10, 8, 8, 9, courseJava,
				student4);
		final StudentNotes notes7 = new StudentNotes(7, 10, 9, 9, coursePHP,
				student4);
		final StudentNotes notes8 = new StudentNotes(9, 9, 9, 9, courseNET,
				student5);
		final StudentNotes notes9 = new StudentNotes(8, 6, 6, 7, courseJava,
				student5);
		final StudentNotes notes10 = new StudentNotes(3, 5, 8, 5, coursePHP,
				student5);
		final StudentNotes notes11 = new StudentNotes(7, 7, 8, 7, courseJava,
				student6);
		final StudentNotes notes12 = new StudentNotes(8, 8, 8, 8, coursePHP,
				student6);
		final StudentNotes notes13 = new StudentNotes(6, 7, 8, 7, courseNET,
				student7);
		final StudentNotes notes14 = new StudentNotes(4, 3, 3, 3, courseJava,
				student8);
		final StudentNotes notes15 = new StudentNotes(5, 8, 9, 7, coursePHP,
				student9);
		final StudentNotes notes16 = new StudentNotes(10, 8, 8, 9, courseJava,
				student10);
		final StudentNotes notes17 = new StudentNotes(7, 10, 9, 9, coursePHP,
				student10);
		final StudentNotes notes18 = new StudentNotes(9, 9, 9, 9, courseNET,
				student11);
		final StudentNotes notes19 = new StudentNotes(8, 6, 6, 7, courseJava,
				student12);
		final StudentNotes notes20 = new StudentNotes(3, 5, 4, 4, coursePHP,
				student12);
		final StudentNotes notes21 = new StudentNotes(7, 7, 3, 6, courseJava,
				student13);
		final StudentNotes notes22 = new StudentNotes(8, 8, 8, 8, coursePHP,
				student14);
		final StudentNotes notes23 = new StudentNotes(6, 7, 8, 7, courseNET,
				student14);
		final StudentNotes notes24 = new StudentNotes(4, 3, 3, 3, courseJava,
				student14);
		final StudentNotes notes25 = new StudentNotes(5, 8, 9, 7, coursePHP,
				student15);
		final StudentNotes notes26 = new StudentNotes(4, 4, 5, 4, courseJava,
				student16);
		final StudentNotes notes27 = new StudentNotes(3, 3, 3, 3, coursePHP,
				student16);
		final StudentNotes notes28 = new StudentNotes(9, 9, 9, 9, courseNET,
				student17);
		final StudentNotes notes29 = new StudentNotes(8, 6, 6, 7, courseJava,
				student18);
		final StudentNotes notes30 = new StudentNotes(3, 5, 8, 5, coursePHP,
				student19);
		
		 data.save(notes1);
		 data.save(notes2);
		 data.save(notes3);
		 data.save(notes4);
		 data.save(notes5);
		 data.save(notes6);
		 data.save(notes7);
		 data.save(notes8);
		 data.save(notes9);
		 data.save(notes10);
		 data.save(notes11);
		 data.save(notes12);
		 data.save(notes13);
		 data.save(notes14);
		 data.save(notes15);
		 data.save(notes16);
		 data.save(notes17);
		 data.save(notes18);
		 data.save(notes19);
		 data.save(notes20);
		 data.save(notes21);
		 data.save(notes22);
		 data.save(notes23);
		 data.save(notes24);
		 data.save(notes25);
		 data.save(notes26);
		 data.save(notes27);
		 data.save(notes28);
		 data.save(notes29);
		 data.save(notes30);

		List<StudentNotes> asList = data.createQuery(StudentNotes.class)
				.field("finalNote").greaterThan(4).asList();

		System.out.println("Estudiantes que aprobaron su curso: \n");
		for (int i = 0; i < asList.size(); i++) {
			System.out.println(i + "-" + " "
					+ asList.get(i).getStudent().getFirstName() + " Curso: "
					+ asList.get(i).getCourse().getCourseName());
		}

	}
}
