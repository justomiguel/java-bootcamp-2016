print("***********Exercise Number 2 of Topic 5 of Java Bootcamp*********");

print("");

print("***********Fetch all students whose notes in a specific course were greater than 4.*********");

print ("");

print("***********Fetch all students whose notes in Course Bootcamp JAVA were greater than 4.*********");

var miCursor = db.Course_List.find({$and : [{Course : 1}, {Final_Note : {$gt : 4}}]});

while (miCursor.hasNext()){
    	printjson(miCursor.next());
};  

print ("");

print("***********Fetch all students whose notes in Course Bootcamp Web UI were greater than 4.*********");

var miCursor = db.Course_List.find({$and : [{Course : 2}, {Final_Note : {$gt : 4}}]});

while (miCursor.hasNext()){
    	printjson(miCursor.next());
};

print ("");

print("***********Fetch all students whose notes in Course Bootcamp PHP were greater than 4.*********");

var miCursor = db.Course_List.find({$and : [{Course : 3}, {Final_Note : {$gt : 4}}]});

while (miCursor.hasNext()){
    	printjson(miCursor.next());
};

	






