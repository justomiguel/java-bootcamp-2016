### Mapping model to MongoDB ###

use high_school


db.notes.insertMany([
	{
		course_id: ObjectId("56de12fe91a38227a05f7416"),
		student: {
			first_name: "Juan", last_name: "Pereyra", birth_date: new Date('Oct 06, 1991')
		},
		partial_notes: [1,4,3],
		final_note: 7
	},
	{
		course_id: ObjectId("56de12fe91a38227a05f7417"),
		student: {
			first_name: "Juan", last_name: "Pereyra", birth_date: new Date('Oct 06, 1991')
		},
		partial_notes: [2,2,4],
		final_note: 3
	},
	{
		course_id: ObjectId("56de12fe91a38227a05f7416"),
		student: {
			first_name: "Horacio", last_name: "Tanek", birth_date: new Date('Dic 26, 1984')
		},
		partial_notes: [6,8,9],
		final_note: 5
	},
	{
		course_id: ObjectId("56de12fe91a38227a05f7416"),
		student: {
			first_name: "Pepe", last_name: "Argenti", birth_date: new Date('Feb 11, 1982')
		},
		partial_notes: [2,4,5],
		final_note: 4
	},
	{
		course_id: ObjectId("56de12fe91a38227a05f7417"),
		student: {
			first_name: "Lalo", last_name: "Mir", birth_date: new Date('Sep 06, 1965')
		},
		partial_notes: [2,4,5],
		final_note: 5
	},
	{
		course_id: ObjectId("56de12fe91a38227a05f7417"),
		student: {
			first_name: "Arquimedes", last_name: "Puccio", birth_date: new Date('Jun 12, 1990')
		},
		partial_notes: [4,4,5],
		final_note: 8
	}])

db.courses.insertMany([
	{
		name: "Introducción a la Filosofía",
		assigned_teacher: {
			first_name: "Pepe", last_name: "Basualdo", birth_date: new Date('Oct 06, 1973')
		},
		hours_by_week: 5,
		schedule_time: [
			{ day: 1, hour_in: "17:00", hour_out: "19:00" },
			{ day: 4, hour_in: "14:00", hour_out: "16:00" },
		]
	},
	{
		name: "Software Libre 101",
		assigned_teacher: {
			first_name: "Pepe", last_name: "Basualdo", birth_date: new Date('Oct 06, 1973')
		},
		hours_by_week: 5,
		schedule_time: [
			{ day: 2, hour_in: "10:00", hour_out: "13:00" },
			{ day: 3, hour_in: "19:00", hour_out: "22:00" },
		]
	}])
	
### Queries ###
db.notes.find(
	{course_id: "INSERT SPECIFIC COURSE ID HERE", final_note: { $gt: 4}},
	{_id:0, 'student.first_name': 1, 'student.last_name': 1}
)

# Desc Order
db.courses.find({'assigned_teacher.last_name': "Basualdo"},{_id:0, name:1}).sort({'name':-1})

# Asc Order
db.courses.find({'assigned_teacher.last_name': "Basualdo"},{_id:0, name:1}).sort({'name':1})
