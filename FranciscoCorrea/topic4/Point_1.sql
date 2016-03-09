### Punto 1 ###

CREATE DATABASE high_school;

CREATE TABLE IF NOT EXISTS student ( 
	registration_number INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL, 
	last_name VARCHAR(50) NOT NULL,
	birth_date DATE
	);

CREATE TABLE IF NOT EXISTS teacher (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE
    );

CREATE TABLE IF NOT EXISTS course (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    assigned_teacher INT NOT NULL,
    hours_by_week INT,
    CONSTRAINT `fk_course_teacher`
		FOREIGN KEY (assigned_teacher) REFERENCES teacher (id)
    );

CREATE TABLE IF NOT EXISTS schedule_time ( 
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	day VARCHAR(10) NOT NULL, 
	hour_in TIME NOT NULL, 
	hour_out TIME NOT NULL, 
	course INT NOT NULL, 
	CONSTRAINT `fk_schedule_course` 
		FOREIGN KEY (course) REFERENCES course (id) 
	);
	
CREATE TABLE IF NOT EXISTS student_by_course (
	student INT NOT NULL,
	course INT NOT NULL,
	first_note INT,
	second_note INT,
	third_note INT,
	final_note INT NOT NULL,
	PRIMARY KEY (student, course),
	CONSTRAINT `fk_student`
		FOREIGN KEY (student) REFERENCES student (registration_number),
	CONSTRAINT `fk_course` 
		FOREIGN KEY (course) REFERE	CES course (id)
	);


