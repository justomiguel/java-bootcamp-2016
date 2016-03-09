package bootcamp.topic5.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;


public class Base {

	@Id
	protected ObjectId id;
	
	public Base() {
		super();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
}
