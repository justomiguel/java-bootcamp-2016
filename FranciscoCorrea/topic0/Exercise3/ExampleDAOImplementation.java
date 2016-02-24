package topic0.Exercise3;

public class ExampleDAOImplementation implements ExampleDAO {

	@Override
	public void delete(int id) {
		System.out.println("DELETE FROM example WHERE id = " + id);
		System.out.println("Fila Nro: " + id + " borrada.");
	}

	@Override
	public ExampleModel findById(int id) {
		System.out.println("SELECT FROM example WHERE id = " + id);
		return null; // Must be return a ExampleModel object. 
	}
}
