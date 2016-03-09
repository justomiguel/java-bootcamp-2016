#Create and use database HighSchool
create database HighSchool;
use HighSchool;

#Create tables
CREATE TABLE Student (Registration_Number INT NOT NULL , 
    First_Name TEXT NOT NULL,
    Last_Name TEXT NOT NULL, 
    Date_Of_Birth DATE NOT NULL, 
    PRIMARY KEY (Registration_Number));
    
CREATE TABLE Teacher (DNI INT NOT NULL , 
    First_Name TEXT NOT NULL,
    Last_Name TEXT NOT NULL, 
    Date_Of_Birth DATE NOT NULL, 
    PRIMARY KEY (DNI));
    
CREATE TABLE Course (ID INT NOT NULL AUTO_INCREMENT , 
    Course_Name TEXT NOT NULL,
    Assigned_Teacher INT NOT NULL, 
    Hours_By_Week INT NOT NULL, 
    PRIMARY KEY (ID),
    foreign key (Assigned_Teacher)
    REFERENCES Teacher(DNI));
    
CREATE TABLE Course_List (ID INT NOT NULL AUTO_INCREMENT , 
    Course INT NOT NULL,
    Student INT NOT NULL,
    Partial_Note1 INT,
    Partial_Note2 INT,
    Partial_Note3 INT,
    Final_Note INT,
    PRIMARY KEY (ID),
    foreign key (Course)
    REFERENCES Course(ID),
    foreign key (Student)
    REFERENCES Student(Registration_Number));
    
CREATE TABLE Days_Of_Week (ID INT NOT NULL AUTO_INCREMENT , 
    DOW_Day TEXT NOT NULL,
    PRIMARY KEY (ID));
    
CREATE TABLE Classes_Of_Week (ID INT NOT NULL AUTO_INCREMENT , 
    COW_Day INT NOT NULL,
    COW_Hour TEXT NOT NULL,
    COW_Course INT NOT NULL,
    PRIMARY KEY (ID),
    foreign key (COW_Course)
    REFERENCES Course_List(ID),
    foreign key (COW_Day)
    REFERENCES Days_Of_Week(ID));
    
    

#Insert neccesary information to work
INSERT low_priority INTO Student (Registration_Number, First_Name, Last_Name, Date_Of_Birth) 
		VALUES
        (1,"Ruben","Gonzalez",'1990-04-13'),
        (2,"Miguel","Gimenez",'1993-08-22'),
        (3,"Ernesto","Acosta",'1992-06-30'),
        (4,"Estela","Balestra",'1988-02-06'),
        (5,"Rocio","Demarchi",'1986-11-11'),
        (6,"Justo","Perez",'1996-01-19'),
        (7,"Marina","Palacios",'1991-10-24'),
        (8,"Nidia","Garcia",'1990-04-04'),
        (9,"Juan","Brest",'1978-08-08'),
        (10,"Francisca","Nocetti",'1993-03-14');
    
INSERT low_priority INTO Teacher (DNI, First_Name, Last_Name, Date_Of_Birth) 
		VALUES
        (1,"Pedro Luis","Alfonzo",'1965-07-18'),
        (2,"Sonia","Mariño",'1971-09-29'),
        (3,"Paola","Insaurralde",'1970-01-30');
        
INSERT low_priority INTO Course (Course_Name, Assigned_Teacher, Hours_By_Week) 
		VALUES
        ("Bootcamp JAVA",1,8),
        ("Bootcamp Web UI",2,6),
        ("Bootcamp PHP",3,8);

INSERT low_priority INTO Course_List (Course, Student,Partial_Note1, Partial_Note2,Partial_Note3, Final_Note) 
		VALUES
        (1,1,6,8,7,7),(1,2,4,6,5,5),(1,3,9,8,8,8.33),(1,4,7,7,8,7.33),(1,5,3,4,2,3),(1,6,10,10,9,9.66),(1,7,5,6,5,5.33),(1,8,4,10,2,5.33),(1,9,8,9,9,8.33),(1,10,7,4,10,7),
        (2,1,4,6,5,5),(2,2,3,4,2,3),(2,3,4,10,2,5.33),(2,4,6,8,7,7),(2,5,10,10,9,9.66),(2,6,7,7,8,7.33),(2,7,7,4,10,7),(2,8,4,10,2,5.33),(2,9,2,3,4,3),(2,10,4,4,5,4.33),
        (3,1,6,8,7,7),(3,2,4,6,5,5),(3,3,9,8,8,8.33),(3,4,4,10,2,5.33),(3,5,10,10,9,9.66),(3,6,2,3,4,3),(3,7,7,4,10,7),(3,8,2,3,4,3),(3,9,10,10,9,9.66),(3,10,3,4,2,3);
        
INSERT low_priority INTO Days_Of_Week (DOW_Day) 
		VALUES
        ("Monday"),("Tuesday"),("Wednesday"),("Thursday"),("Friday"),("Saturday"),("Sunday");

INSERT low_priority INTO Classes_Of_Week (COW_Day, COW_Hour, COW_Course) 
		VALUES
        (1,"08:00",1),(3,"08:00",1),(5,"10:00",1),
        (1,"17:00",2),(2,"17:00",2),(4,"19:00",2),
        (1,"12:00",3),(3,"12:00",3),(4,"14:00",3);
        


#Show items

#List of courses with their teachers and students
SELECT high_priority concat("COURSE: ", Course_Name) AS Course, concat('\nTeacher: ', Teacher.Last_Name, ', ', Teacher.First_Name) AS Teacher, 
	concat(Student.Last_Name, ", ",Student.First_Name) AS Students
    
	FROM Course_List 
    INNER JOIN Course ON course_List.Course = Course.ID
    INNER JOIN Teacher ON Course.Assigned_Teacher = Teacher.DNI
    INNER JOIN Student ON Course_List.Student = Student.Registration_Number
	
    ORDER BY Course.ID, Student.Last_Name ASC;
    
#Percentage of students that passed/failed a given course
SELECT high_priority concat("Passed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note >=7 AND Course = 1)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 1))), "%", ", Failed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note < 7 AND Course = 1)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 1))), "%")  AS Bootcamp_JAVA,
	   concat("Passed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note >=7 AND Course = 2)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 2))), "%", ", Failed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note < 7 AND Course = 2)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 2))), "%")  AS Bootcamp_WebUI,
	   concat("Passed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note >=7 AND Course = 3)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 3))), "%", ", Failed: ", round((((Select count(Final_Note) from Course_List WHERE Final_Note < 7 AND Course = 3)*100)/ (SELECT count(*) FROM Course_List WHERE Course = 3))), "%")  AS Bootcamp_PHP
    
    FROM Course_List course
    LIMIT 1;
    
#List of timeline of courses assigned to a teacher
SELECT high_priority concat(Teacher.Last_Name, ", ", Teacher.First_Name) AS Teacher, concat(Days_Of_Week.DOW_Day, " ", Classes_Of_Week.COW_Hour, ": ", Course.Course_Name) AS Schedule_Of_Teacher
	FROM Classes_Of_Week 
    INNER JOIN Course ON Course.ID = Classes_Of_Week.COW_Course
    INNER JOIN Teacher ON Course.Assigned_Teacher = Teacher.DNI
    INNER JOIN Days_Of_Week ON Days_Of_Week.ID = Classes_Of_Week.COW_Day
    
    ORDER BY Teacher.Last_Name, Classes_Of_Week.COW_Day;