package topic0.Exercise2;

public class PostgreConnection implements Connection {
	
	@Override
	public void connect() {
		System.out.println("Connecting to postgres... ");
	}

}
