package topic0;

public class PostgreSQLConnector implements SQLConnector {

	@Override
	public void connect() {
		System.out.println("Connecting with PostgreSQL connector");
	}

}
