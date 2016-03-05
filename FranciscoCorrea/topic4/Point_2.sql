### Punto 2 ###

INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Tito", "Fatale", "1985-12-25");
INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Juan Carlos", "Petruzza", "1970-02-17");
INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Pepe", "Barreta Smith", "1979-11-02");

INSERT INTO course (name, assigned_teacher, hours_by_week) VALUES ("Introducción a la Filosofia", 4, 10);
INSERT INTO course (name, assigned_teacher, hours_by_week) VALUES ("PHP Avanzado", 3, 10);
INSERT INTO course (name, assigned_teacher, hours_by_week) VALUES ("Carpinteria 101", 2, 10);

INSERT INTO schedule_time (day, hour_in, hour_out, course) VALUES 
	("Lunes", '08:00:00', '10:00:00', 1),
	("Martes", '12:00:00', '14:00:00', 1),
	("Lunes", '10:00:00', '12:00:00', 2),
	("Viernes", '16:00:00', '18:00:00', 2),
	("Miercoles", '15:00:00', '17:00:00', 3),
	("Jueves", '15:00:00', '17:00:00', 3),
	("Miercoles", '15:00:00', '17:00:00', 2);

INSERT INTO student (first_name, last_name, birth_date) VALUES 
	("Ernesto", "Castro", "1991-01-05"),
	("Michael", "Vainilla", "1991-01-21"),
	("Fitipaldo", "Lopez", "1988-08-24"),
	("Pepe", "Basualdo", "1974-05-21"),
	("Lalo", "Mir", "1975-12-4"),
	("Ofelia", "Lambu", "1994-11-28"),
	("Miguel Angel", "Troncoso", "1984-10-14"),
	("Barbara", "Paniagua", "1994-11-27"),
	("Roque", "Leyenda", "1992-12-4"),
	("Tito Arrow", "Noir", "1985-04-5"),
	("Angela", "Gomez Azura", "1945-04-3"),
	("Florencia", "Gomez Azura", "1943-04-18"),
	("Atahualpa", "Martins", "1974-06-8"),
	("Son", "Goku", "1985-01-9"),
	("Ernesto", "Tatantatangol", "1968-02-26");

INSERT INTO student_by_course (student, course, final_note) VALUES 
	(1,1,5), (2,1,4), (3,1,1), (4,1,10), (5,1,6), (6,1,5), (7,1,8), (8,1,9), (9,1,7), (10,1,2),
	(6,2,4), (7,2,4), (8,2,7), (9,2,2), (10,2,2), (11,2,4), (12,2,5), (13,2,1), (14,2,10), (15,2,5),
	(1,3,6), (3,3,10), (5,3,8), (7,3,5), (9,3,9), (11,3,4), (13,3,2), (15,3,4), (14,3,3), (12,3,5);

