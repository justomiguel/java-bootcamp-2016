package bootcamp.topic5.morphia;


import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

public class Main {

	public static void main(String[] args) {
		
		// Connecting and starting DAOs
		Datastore ds = ConnectToMongo.getDatastore();
		NoteDAO noteDAO = new NoteDAO(Note.class, ds);
		
		ObjectId oid = new ObjectId("56de12fe91a38227a05f7416");
		
		// Making query for step 2
		Query<Note> query = noteDAO.createQuery()
				.retrievedFields(true, "student.last_name","student.first_name");
		query.field("final_note").greaterThan(4);
		query.field("course_id").equal(oid);
		
		// Seeing results
		QueryResults<Note> results = noteDAO.find(query);
		for (Note result : results ) {
			System.out.println(result.getStudent().getLast_name());
		}

	}

}
