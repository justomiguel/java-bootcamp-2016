drop table if exists course;
drop table if exists student_course;
drop table if exists teacher;
drop table if exists student;


CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_birth` date NOT NULL,
  PRIMARY KEY (`id_teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT low_priority INTO `teacher`
(`id_teacher`,
`first_name`,
`last_name`,
`date_birth`)
VALUES
(1,"Lisandro","Chichi","1980-11-05"),
(2,"Carlos","Penzo","1979-11-05"),
(3,"Sebas","Lopez","1981-11-05");


CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `name_course` varchar(45) NOT NULL,
  `hours_week` int(11) NOT NULL,
  `schedule_time` int(11) NOT NULL,
  `teacher_assigned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_course`),
  foreign key (teacher_assigned)
  REFERENCES teacher(id_teacher)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT low_priority INTO `course`
(`id_course`,
`name_course`,
`hours_week`,
`schedule_time`,
`teacher_assigned`)
VALUES
(1,"Java", 16,1,2),
(2,"PHP", 16,2,3),
(3,".NET", 16,3,1);

CREATE TABLE `course_schedule`(
`id` int(11) not null auto_increment,
`day` varchar(45) not null,
`hour` varchar(45) not null,
`id_course` int (11) not null,
primary key (`id`),
foreign key (id_course)
references course(id_course)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT low_priority INTO `high-school`.`course_schedule`
(`id`,
`day`,
`hour`,
`id_course`)
VALUES
(1,"Monday","09:00 - 11:00",1),
(2,"Monday","15:00 - 17:30",1),
(3,"Friday","10:00 - 14:00",1),
(4,"Tuesday","19:00 - 21:00",2),
(5,"Wednesday","09:00 - 13:00",2),
(6,"Friday","12:00 - 15:30",2),
(7,"Thursday","14:00 - 18:00",3),
(8,"Friday","09:30 - 12:30",3);


CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `registration_number` int(11) NOT NULL,
  `date_birth` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `registration_number` (`registration_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT low_priority INTO `student` 
(`id`,
 `first_name`,
 `last_name`,
 `registration_number`,
 `date_birth`)
 
VALUES
(1,"juan","perez",43579,'1990-11-01'),
(2,"alberto","lopez",43570,'1991-12-11'),
(3,"julian","ramirez",42579,'1992-01-01'),
(4,"santiago","gutierrez",23579,'1990-07-01'),
(5,"rodolfo","beron",43379,'1990-04-21'),
(6,"antonieto","cristaldo",1579,'1990-06-11'),
(7,"ramiro","dutti",4319,'1990-01-15'),
(8,"sergio","hermida",4353,'1990-03-01'),
(9,"rodrigo","fages",43456,'1990-03-21'),
(10,"luis","illia",45679,'1990-09-01'),
(11,"jose","jerez",43079,'1990-08-12'),
(12,"carlos","llano",41179,'1990-08-14'),
(13,"juan","martin",43569,'1990-10-03'),
(14,"antonio","nieves",44089,'1990-09-01'),
(15,"pepe","ortega",41119,'1990-02-21'),
(16,"miranda","palacios",4279,'1990-11-11'),
(17,"agostina","donatto",43544,'1990-10-01'),
(18,"agustin","martinez",49863,'1990-12-12'),
(19,"maria","bou",54645,'1990-12-24'),
(20,"antonella","alario",34234,'1990-01-25');

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) NOT NULL,
  `id_course` int(11) NOT NULL,
  `note1` float NOT NULL,
  `note2` float NOT NULL,
  `note3` float NOT NULL,
  `final_note` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_student` (`id_student`),
  KEY `id_course` (`id_course`),
  CONSTRAINT `studentcourse_idcourse` 
  FOREIGN KEY (`id_course`) REFERENCES `course` (`id_course`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentcourse_idstudent` 
  FOREIGN KEY (`id_student`) REFERENCES `student` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=101 ;

INSERT low_priority INTO `student_course`
(`id`, 
`id_student`, 
`id_course`, 
`note1`, 
`note2`, 
`note3`, 
`final_note`)
 VALUES

(1,1,1,7,7,8,7),
(2,4,1,8,8,8,8),
(3,6,1,6,7,8,7),
(4,7,1,4,3,3,3),
(5,8,1,5,8,9,7),
(6,9,1,10,8,8,9),
(7,12,1,7,10,9,9),
(8,13,1,9,9,9,9),
(9,15,1,8,6,6,7),
(10,16,1,3,5,8,5),
(11,2,2,9,7,9,8),
(12,3,2,5,5,8,7),
(13,4,2,4,6,6,5),
(14,7,2,3,9,9,7),
(15,9,2,10,9,9,9),
(16,11,2,2,10,9,7),
(17,12,2,8,9,8,8),
(18,14,2,9,6,6,7),
(19,16,2,8,8,10,9),
(20,18,2,7,7,5,6),
(21,1,3,9,9,8,9),
(22,3,3,7,6,6,6),
(23,5,3,7,5,2,5),
(24,6,3,9,7,9,9),
(25,7,3,7,8,8,8),
(26,10,3,7,5,6,6),
(27,11,3,7,4,4,6),
(28,13,3,1,7,10,6),
(29,14,3,1,10,10,7),
(30,17,3,10,7,4,7);

#List students and teachers for a given course
select high_priority t.first_name, t.last_name, s.first_name, s.last_name, c.name_course
from student s, teacher t, course c
where  teacher_assigned = 2 and t.id_teacher = c.teacher_assigned
order by s.last_name;

#Percentage of students that passed/failed a given course
Select high_priority s.id, (Select count(sc.final_note) From student s, student_course sc
where sc.final_note > 6 and sc.id_course = 1 and s.id = sc.id_student)*100/(Count(sc.final_note)) as PercentPassed
From student s, student_course sc
where sc.id_course = 1 and s.id = sc.id_student;

#For a given teacher, list the timeline for each course that he is assigned to (ordered by date), 
#and the course name
select high_priority t.first_name,t.last_name, cs.day, cs.hour, c.name_course
from teacher t, course_schedule cs,course c
where cs.id_course = 1 and c.id_course = cs.id_course and t.id_teacher = c.teacher_assigned