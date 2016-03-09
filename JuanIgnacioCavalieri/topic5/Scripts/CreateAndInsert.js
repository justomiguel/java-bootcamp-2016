conn = new Mongo();
db = conn.getDB("highschool");

print("***********Creating database of Topic 5 of Java bootcamp*********");

db.Student.insert(Student = [
		{
		Registration_Number : 1,
		First_Name : "Ruben",
		Last_Name : "Gonzalez", 
		Date_Of_Birth : '1990-04-13'
		},

		{
		Registration_Number : 2,
		First_Name : "Miguel",
		Last_Name : "Gimenez", 
		Date_Of_Birth : '1993-08-22'
		},

		{
		Registration_Number : 3,
		First_Name : "Ernesto",
		Last_Name : "Acosta", 
		Date_Of_Birth : '1992-06-30'
		},

		{
		Registration_Number : 4,
		First_Name : "Estela",
		Last_Name : "Balestra", 
		Date_Of_Birth : '1988-02-06'
		},

		{
		Registration_Number : 5,
		First_Name : "Rocio",
		Last_Name : "Demarchi", 
		Date_Of_Birth : '1986-11-11'
		},

		{
		Registration_Number : 6,
		First_Name : "Justo",
		Last_Name : "Perez", 
		Date_Of_Birth : '1996-01-19'
		},

		{
		Registration_Number : 7,
		First_Name : "Marina",
		Last_Name : "Palacios", 
		Date_Of_Birth : '1991-10-24'
		},

		{
		Registration_Number : 8,
		First_Name : "Nidia",
		Last_Name : "Garcia", 
		Date_Of_Birth : '1990-04-04'
		},

		{
		Registration_Number : 9,
		First_Name : "Juan",
		Last_Name : "Brest", 
		Date_Of_Birth : '1978-08-08'
		},

		{
		Registration_Number : 10,
		Firs_Name : "Francisca",
		Last_Name : "Nocetti", 
		Date_Of_Birth : '1993-03-14'
		}


	]);

db.Teacher.insert(Teacher = [

		{
		DNI : 1,
		First_Name : "Pedro Luis",
		Last_Name : "Alfonzo", 
		Date_Of_Birth : '1965-07-18'
		},

		{
		DNI : 2,
		First_Name : "Sonia",
		Last_Name : "Marinio", 
		Date_Of_Birth : '1971-09-29'
		},

		{
		DNI : 3,
		First_Name : "Paola",
		Last_Name : "Insaurralde", 
		Date_Of_Birth : '1970-01-30'
		}
	]);


db.Course.insert(Course = [
	
		{
		ID : 1,
		Course_Name : "Bootcamp JAVA",
		Assigned_Teacher : 1, 
		Hours_By_Week : 8
		},

		{
		ID : 2,
		Course_Name : "Bootcamp Web UI",
		Assigned_Teacher : 2, 
		Hours_By_Week : 6
		},

		{
		ID : 3,
		Course_Name : "Bootcamp PHP",
		Assigned_Teacher : 3, 
		Hours_By_Week : 8
		}

	]);

db.Course_List.insert(Course_List = [

		{
		ID : 1,
		Course : 1,
		Student : 1, 
		Partial_Note1 : 8,
		Partial_Note2 : 6,
		Partial_Note3 : 7,
		Final_Note : 7
		},

		{
		ID : 2,
		Course : 1,
		Student : 2, 
		Partial_Note1 : 3,
		Partial_Note2 : 4,
		Partial_Note3 : 2,
		Final_Note : 3
		},

		{
		ID : 3,
		Course : 1,
		Student : 3, 
		Partial_Note1 : 9,
		Partial_Note2 : 8,
		Partial_Note3 : 8,
		Final_Note : 8.33
		},

		{
		ID : 4,
		Course : 1,
		Student : 4, 
		Partial_Note1 : 7,
		Partial_Note2 : 7,
		Partial_Note3 : 8,
		Final_Note : 7.33
		},

		{
		ID : 5,
		Course : 1,
		Student : 5, 
		Partial_Note1 : 3,
		Partial_Note2 : 4,
		Partial_Note3 : 2,
		Final_Note : 3
		},

		{
		ID : 6,
		Course : 1,
		Student : 6, 
		Partial_Note1 : 10,
		Partial_Note2 : 10,
		Partial_Note3 : 9,
		Final_Note : 9.66
		},

		{
		ID : 7,
		Course : 1,
		Student : 7, 
		Partial_Note1 : 5,
		Partial_Note2 : 6,
		Partial_Note3 : 5,
		Final_Note : 5.33
		},

		{
		ID : 9,
		Course : 1,
		Student : 9, 
		Partial_Note1 : 8,
		Partial_Note2 : 9,
		Partial_Note3 : 9,
		Final_Note : 8.33
		},

		{
		ID : 10,
		Course : 1,
		Student : 10, 
		Partial_Note1 : 4,
		Partial_Note2 : 3,
		Partial_Note3 : 2,
		Final_Note : 3
		},

		{
		ID : 11,
		Course : 2,
		Student : 1, 
		Partial_Note1 : 4,
		Partial_Note2 : 6,
		Partial_Note3 : 5,
		Final_Note : 5
		},

		{
		ID : 12,
		Course : 2,
		Student : 2, 
		Partial_Note1 : 3,
		Partial_Note2 : 4,
		Partial_Note3 : 2,
		Final_Note : 3
		},

		{
		ID : 13,
		Course : 2,
		Student : 3, 
		Partial_Note1 : 6,
		Partial_Note2 : 8,
		Partial_Note3 : 7,
		Final_Note : 7
		},

		{
		ID : 14,
		Course : 2,
		Student : 4, 
		Partial_Note1 : 7,
		Partial_Note2 : 7,
		Partial_Note3 : 8,
		Final_Note : 7.33
		},

		{
		ID : 15,
		Course : 2,
		Student : 5, 
		Partial_Note1 : 7,
		Partial_Note2 : 4,
		Partial_Note3 : 10,
		Final_Note : 7
		},

		{
		ID : 16,
		Course : 2,
		Student : 6, 
		Partial_Note1 : 2,
		Partial_Note2 : 4,
		Partial_Note3 : 3,
		Final_Note : 3
		},

		{
		ID : 17,
		Course : 2,
		Student : 7, 
		Partial_Note1 : 10,
		Partial_Note2 : 10,
		Partial_Note3 : 10,
		Final_Note : 10
		},

		{
		ID : 18,
		Course : 2,
		Student : 8, 
		Partial_Note1 : 2,
		Partial_Note2 : 3,
		Partial_Note3 : 2,
		Final_Note : 2.33
		},

		{
		ID : 19,
		Course : 2,
		Student : 9, 
		Partial_Note1 : 7,
		Partial_Note2 : 7,
		Partial_Note3 : 6,
		Final_Note : 6.66
		},

		{
		ID : 20,
		Course : 2,
		Student : 10, 
		Partial_Note1 : 4,
		Partial_Note2 : 4,
		Partial_Note3 : 3,
		Final_Note : 3.66
		},

		{
		ID : 21,
		Course : 3,
		Student : 1, 
		Partial_Note1 : 6,
		Partial_Note2 : 8,
		Partial_Note3 : 7,
		Final_Note : 7
		},

		{
		ID : 22,
		Course : 3,
		Student : 2, 
		Partial_Note1 : 4,
		Partial_Note2 : 4,
		Partial_Note3 : 3,
		Final_Note : 3.66
		},

		{
		ID : 23,
		Course : 3,
		Student : 3, 
		Partial_Note1 : 7,
		Partial_Note2 : 8,
		Partial_Note3 : 8,
		Final_Note : 7.66
		},

		{
		ID : 24,
		Course : 3,
		Student : 4, 
		Partial_Note1 : 8,
		Partial_Note2 : 9,
		Partial_Note3 : 8,
		Final_Note : 8.33
		},

		{
		ID : 25,
		Course : 3,
		Student : 5, 
		Partial_Note1 : 10,
		Partial_Note2 : 10,
		Partial_Note3 : 9,
		Final_Note : 9.66
		},

		{
		ID : 26,
		Course : 3,
		Student : 6, 
		Partial_Note1 : 2,
		Partial_Note2 : 3,
		Partial_Note3 : 4,
		Final_Note : 3
		},

		{
		ID : 27,
		Course : 3,
		Student : 7, 
		Partial_Note1 : 4,
		Partial_Note2 : 4,
		Partial_Note3 : 4,
		Final_Note : 4
		},

		{
		ID : 28,
		Course : 3,
		Student : 8, 
		Partial_Note1 : 1,
		Partial_Note2 : 1,
		Partial_Note3 : 4,
		Final_Note : 2
		},

		{
		ID : 29,
		Course : 3,
		Student : 9, 
		Partial_Note1 : 10,
		Partial_Note2 : 8,
		Partial_Note3 : 6,
		Final_Note : 8
		},

		{
		ID : 30,
		Course : 3,
		Student : 10, 
		Partial_Note1 : 9,
		Partial_Note2 : 10,
		Partial_Note3 : 10,
		Final_Note : 9.66
		}
	]);

db.Days_Of_Week.insert(Days_Of_Week = [

		{
		ID : 1,
		DOW_Name : "Monday"
		},

		{
		ID : 2,
		DOW_Name : "Tuesday"
		},

		{
		ID : 3,
		DOW_Name : "Wednesday"
		},

		{
		ID : 4,
		DOW_Name : "Thursday"
		},

		{
		ID : 5,
		DOW_Name : "Friday"
		},

		{
		ID : 6,
		DOW_Name : "Saturday"
		},

		{
		ID : 7,
		DOW_Name : "Sunday"
		}
	]);

db.Classes_Of_Week.insert(Classes_Of_Week = [

		{
		ID : 1,
		COW_Day : 1,
		COW_Hour : "08:00",
		COW_Course : 1
		},

		{
		ID : 2,
		COW_Day : 3,
		COW_Hour : "08:00",
		COW_Course : 1
		},

		{
		ID : 3,
		COW_Day : 5,
		COW_Hour : "10:00",
		COW_Course : 1
		},

		{
		ID : 4,
		COW_Day : 1,
		COW_Hour : "17:00",
		COW_Course : 2
		},

		{
		ID : 5,
		COW_Day : 2,
		COW_Hour : "17:00",
		COW_Course : 2
		},

		{
		ID : 6,
		COW_Day : 4,
		COW_Hour : "19:00",
		COW_Course : 2
		},

		{
		ID : 7,
		COW_Day : 1,
		COW_Hour : "12:00",
		COW_Course : 3
		},

		{
		ID : 8,
		COW_Day : 3,
		COW_Hour : "12:00",
		COW_Course : 3
		},

		{
		ID : 9,
		COW_Day : 4,
		COW_Hour : "14:00",
		COW_Course : 3
		}

	]);

print(" ");
print("***********Database succesfully created*********");