package topic0.Exercise3;

public class ProxyExampleDAO implements ExampleDAO {
	
	private ExampleDAOImplementation realImplementation;
	
	
	@Override
	public void delete(int id) {
		if (this.realImplementation == null) {
			this.realImplementation = new ExampleDAOImplementation();
		}
		this.realImplementation.delete(id);
	}

	@Override
	public ExampleModel findById(int id) {
		if (this.realImplementation == null) {
			this.realImplementation = new ExampleDAOImplementation();
		}
		this.realImplementation.findById(id);
		return null; // Must be return a Example Model Object
	}
}
