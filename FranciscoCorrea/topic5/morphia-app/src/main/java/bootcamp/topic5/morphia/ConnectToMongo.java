package bootcamp.topic5.morphia;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class ConnectToMongo {
	static Morphia morphia;
	static Datastore datastore;
	
	public static Datastore getDatastore() {
		morphia = new Morphia();
		datastore = morphia.createDatastore(new MongoClient(), "high_school");
		
		morphia.map(Note.class, Course.class);
		
		return datastore;
	} 
}
