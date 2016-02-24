package BuilderConnectionDatabase;

public class PostgreSqlConnection extends BuilderConnection{

	@Override
	public void createDriver() {
		// TODO Auto-generated method stub
		conn.setDriver("org.postgresql.Driver");
	}

	@Override
	public void createUrl() {
		// TODO Auto-generated method stub
		conn.setUrl("jdbc:postgresql://localhost:5432/testdb");
		
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		conn.setUser("postgres");
	}

	@Override
	public void createPass() {
		// TODO Auto-generated method stub
		conn.setPass("123");
	}

}