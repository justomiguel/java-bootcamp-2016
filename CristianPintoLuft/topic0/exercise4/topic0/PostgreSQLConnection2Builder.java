package topic0;

public class PostgreSQLConnection2Builder implements DBConnection2Builder {

	private DBConnection2 dbConnection2;

	public PostgreSQLConnection2Builder() {
		dbConnection2 = new DBConnection2();
	}

	@Override
	public void buildConnection() {
		dbConnection2.setConnectionName("PostgreSQL");

	}

	@Override
	public void buildUsername() {
		dbConnection2.setUsername("pepe");

	}

	@Override
	public void buildPassword() {
		dbConnection2.setPassword("muleiro");

	}

	@Override
	public DBConnection2 getDBConnection2() {
		return dbConnection2;
	}

}
