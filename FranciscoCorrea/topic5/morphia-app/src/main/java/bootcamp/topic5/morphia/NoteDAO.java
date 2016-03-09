package bootcamp.topic5.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;


public class NoteDAO extends BasicDAO<Note, ObjectId> {

	public NoteDAO(Class<Note> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	
}
