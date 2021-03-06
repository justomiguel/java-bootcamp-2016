### Punto 3, 4, 5, 6 ###

SELECT HIGH_PRIORITY STRAIGHT_JOIN c.name, t.first_name, st.last_name, st.first_name 
FROM course AS c 
INNER JOIN teacher AS t ON c.assigned_teacher = t.id 
INNER JOIN student_by_course AS st_c ON c.id = st_c.course
INNER JOIN student AS st ON st_c.student = st.registration_number
WHERE c.id = ? # Indicar que curso quiere verse
ORDER BY st.last_name ASC;

SELECT HIGH_PRIORITY count(student) as "Total passed", 
		count(*) /  (SELECT count(student) from student_by_course where course = 3) * 100 as "Percentage"
FROM student_by_course
WHERE course = 3 AND final_note >= 4;


SELECT HIGH_PRIORITY t.last_name, t.first_name, sch.day, sch.hour_in, sch.hour_out, c.name
FROM teacher AS t 
INNER JOIN course AS c ON t.id = c.assigned_teacher
INNER JOIN schedule_time as sch ON c.id = sch.course
WHERE t.id = ? # Indicar profesor que quiere verse
ORDER BY FIELD(sch.day, "Lunes", "Martes", "Miercoles", "Jueves", "Viernes");
 
