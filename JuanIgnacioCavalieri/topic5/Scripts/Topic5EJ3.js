print("***********Exercise Number 3 of Topic 5 of Java Bootcamp*********");

print("");

print("***********Fetch all courses ordered by name for a given teacher.*********");

var teacher = 0;

print ("");
print("***********Teacher: Pedro Alfonzo (DNI: 1)*********");

teacher = 1;

var miCursor = db.Course.find({Assigned_Teacher : teacher});

while (miCursor.hasNext()){
    printjson(miCursor.next());
}; 
  

print ("");
print("***********Teacher: Sonia Marinio (DNI: 2)*********");

teacher = 2;

var miCursor = db.Course.find({Assigned_Teacher : teacher});

while (miCursor.hasNext()){
    printjson(miCursor.next());
}; 

print ("");
print("***********Teacher: Paola Insaurralde (DNI: 3)*********");

teacher = 3;

var miCursor = db.Course.find({Assigned_Teacher : teacher});

while (miCursor.hasNext()){
    printjson(miCursor.next());
}; 
