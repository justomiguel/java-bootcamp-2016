package com.topic5.app;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


/**
 *Main Class App corresponding to the Topic 5 of Java bootcamp
 *It is used to test Mongodb connection and show a specyfic query
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class App 
{
	public static void main(String[] args) throws UnknownHostException,MongoException {
	
		//Set all database attributes
		String dbName = new String("highSchool2");
		Morphia morphia = new Morphia();
		morphia.mapPackage("org.mongodb.morphia.example");
	
		Datastore data = morphia.createDatastore(new MongoClient(), dbName);
		
		
		//Create all Students
		final Student student1 = new Student("Ruben", "Gonzalez", "1990-04-13");
		final Student student2 = new Student("Miguel", "Gimenez", "1993-08-22");
		final Student student3 = new Student("Ernesto", "Acosta", "1992-06-30");
		final Student student4 = new Student("Estela", "Balestra", "1988-02-06");
		final Student student5 = new Student("Rocio", "Demarchi", "1986-11-11");
		final Student student6 = new Student("Justo", "Perez", "1996-01-19");
		final Student student7 = new Student("Marina", "Palacios", "1991-10-24");
		final Student student8 = new Student("Nidia", "Garcia", "1990-04-04");
		final Student student9 = new Student("Juan", "Brest", "1978-08-08");
		final Student student10 = new Student("Francisca", "Nocetti", "1990-04-13");
		
		//Create all Teachers
		final Teacher teacher1 = new Teacher ("Pedro Luis", "Alfonzo", "1965-07-18");
		final Teacher teacher2 = new Teacher ("Sonia", "Marinio", "1971-09-29");
		final Teacher teacher3 = new Teacher ("Paola", "Insaurralde", "1970-01-30");
		
		//Create all Courses
		final Course course1 = new Course("Bootcamp JAVA", 8, teacher1);
		final Course course2 = new Course("Bootcamp Web UI", 6, teacher2);
		final Course course3 = new Course("Bootcamp PHP", 8, teacher3);
		
		//Create all course list
		CourseList courselist1 = new CourseList (course1, student1, 8, 6, 7, 7);
		CourseList courselist2 = new CourseList (course1, student2, 3, 4, 2, 3);
		CourseList courselist3 = new CourseList (course1, student3, 9, 8, 8, 8.33);
		CourseList courselist4 = new CourseList (course1, student4, 7, 7, 8, 7.33);
		CourseList courselist5 = new CourseList (course1, student5, 3, 4, 2, 3);
		CourseList courselist6 = new CourseList (course1, student6, 10, 10, 9, 9.66);
		CourseList courselist7 = new CourseList (course1, student7, 5, 6, 5, 5.33);
		CourseList courselist8 = new CourseList (course1, student8, 5, 5, 5, 5);
		CourseList courselist9 = new CourseList (course1, student9, 8, 9, 9, 8.66);
		CourseList courselist10 = new CourseList (course1, student10, 4, 3, 2, 3);
		
		CourseList courselist11 = new CourseList (course2, student1, 4, 6, 5, 5);
		CourseList courselist12 = new CourseList (course2, student2, 3, 4, 2, 3);
		CourseList courselist13 = new CourseList (course2, student3, 6, 8, 7, 7);
		CourseList courselist14 = new CourseList (course2, student4, 7, 7, 8, 7.33);
		CourseList courselist15 = new CourseList (course2, student5, 7, 4, 10, 7);
		CourseList courselist16 = new CourseList (course2, student6, 2, 4, 3, 3);
		CourseList courselist17 = new CourseList (course2, student7, 10, 10, 10, 10);
		CourseList courselist18 = new CourseList (course2, student8, 2, 3, 2, 2.33);
		CourseList courselist19 = new CourseList (course2, student9, 7, 7, 6, 6.66);
		CourseList courselist20 = new CourseList (course2, student10, 4, 4, 3, 3.66);
		
		CourseList courselist21 = new CourseList (course3, student1, 6, 8, 7, 7);
		CourseList courselist22 = new CourseList (course3, student2, 4, 4, 3, 3.66);
		CourseList courselist23 = new CourseList (course3, student3, 7, 8, 8, 7.66);
		CourseList courselist24 = new CourseList (course3, student4, 8, 9, 8, 8.33);
		CourseList courselist25 = new CourseList (course3, student5, 10, 10, 9, 9.66);
		CourseList courselist26 = new CourseList (course3, student6, 2, 3, 4, 3);
		CourseList courselist27 = new CourseList (course3, student7, 4, 4, 4, 4);
		CourseList courselist28 = new CourseList (course3, student8, 1, 1, 4, 2);
		CourseList courselist29 = new CourseList (course3, student9, 10, 8, 6, 8);
		CourseList courselist30 = new CourseList (course3, student10, 9, 10, 10, 9.66);
		
		
		//Create all days of week
		final DaysOfWeek dow1 = new DaysOfWeek (1, "Monday");
		final DaysOfWeek dow2 = new DaysOfWeek (2, "Tuesday");
		final DaysOfWeek dow3 = new DaysOfWeek (3, "Wednesday");
		final DaysOfWeek dow4 = new DaysOfWeek (4, "Thursday");
		final DaysOfWeek dow5 = new DaysOfWeek (5, "Friday");
		@SuppressWarnings("unused")
		final DaysOfWeek dow6 = new DaysOfWeek (6, "Saturday");
		@SuppressWarnings("unused")
		final DaysOfWeek dow7 = new DaysOfWeek (7, "Sunday");
		
		//Create all classes of week
		final ClassesOfWeek cow1 = new ClassesOfWeek (1, dow1, "08:00", course1);
		final ClassesOfWeek cow2 = new ClassesOfWeek (2, dow3, "08:00", course1);
		final ClassesOfWeek cow3 = new ClassesOfWeek (3, dow5, "10:00", course1);
		
		final ClassesOfWeek cow4 = new ClassesOfWeek (4, dow1, "17:00", course2);
		final ClassesOfWeek cow5 = new ClassesOfWeek (5, dow2, "17:00", course2);
		final ClassesOfWeek cow6 = new ClassesOfWeek (6, dow4, "19:00", course2);
		
		final ClassesOfWeek cow7 = new ClassesOfWeek (7, dow1, "12:00", course3);
		final ClassesOfWeek cow8 = new ClassesOfWeek (8, dow3, "12:00", course3);
		final ClassesOfWeek cow9 = new ClassesOfWeek (9, dow4, "14:00", course3);
		
		
		//Insert data into the database
		data.save(courselist1);
		data.save(courselist2);
		data.save(courselist3);
		data.save(courselist4);
		data.save(courselist5);
		data.save(courselist6);
		data.save(courselist7);
		data.save(courselist8);
		data.save(courselist9);
		data.save(courselist10);
		data.save(courselist11);
		data.save(courselist12);
		data.save(courselist13);
		data.save(courselist14);
		data.save(courselist15);
		data.save(courselist16);
		data.save(courselist17);
		data.save(courselist18);
		data.save(courselist19);
		data.save(courselist20);
		data.save(courselist21);
		data.save(courselist22);
		data.save(courselist23);
		data.save(courselist24);
		data.save(courselist25);
		data.save(courselist26);
		data.save(courselist27);
		data.save(courselist28);
		data.save(courselist29);
		data.save(courselist30);
	
		
		data.save(cow1);
		data.save(cow2);
		data.save(cow3);
		data.save(cow4);
		data.save(cow5);
		data.save(cow6);
		data.save(cow7);
		data.save(cow8);
		data.save(cow9);
		
		
		//Show information "Fetch all students whose notes in a specific course were greater than 4"
		List<CourseList> query = data.createQuery(CourseList.class).field("finalNote").greaterThan(4).asList();
				
		System.out.println("Students whose notes in a specific course were greater than 4: \n");
		
		String courseName = "A" ;
		for (int i = 0; i < query.size(); i++) {
			
			if (courseName.equals("A")){
				courseName = query.get(i).getCourse().getCourseName();
				System.out.println("Course: " + courseName);
				System.out.println(" ");
				System.out.println(query.get(i).getStudent().getLastName() + ", " + query.get(i).getStudent().getFirstName());
			}else{
				if (courseName.equals(query.get(i).getCourse().getCourseName())){
					System.out.println(query.get(i).getStudent().getLastName() + ", " + query.get(i).getStudent().getFirstName());
				}else{
					System.out.println("********************************************************");
					System.out.println(" ");
					courseName = query.get(i).getCourse().getCourseName();
					System.out.println("Course: " + courseName);
					System.out.println(" ");
					System.out.println(query.get(i).getStudent().getLastName() + ", " + query.get(i).getStudent().getFirstName());
				}
			}
			
		}
		
	}
}
