package bootcamp.topic5.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class CourseDAO extends BasicDAO<Course, ObjectId> {

	public CourseDAO(Class<Course> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

}
