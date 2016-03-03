package BuilderConnectionDatabase;

import BuilderConnectionDatabase.Connection.BuilderConnection;

public class PostgreSqlConnection{

	BuilderConnection conn;

	public PostgreSqlConnection() {
		// TODO Auto-generated constructor stub
		conn = new BuilderConnection();

	}

	public String createDriver() {
		// TODO Auto-generated method stub
		return("org.postgresql.Driver");
	}

	public String createUrl() {
		// TODO Auto-generated method stub
		return("jdbc:postgresql://localhost:5432/testdb");

	}

	public String createUser() {
		// TODO Auto-generated method stub
		return("postgres");
	}

	public String createPass() {
		// TODO Auto-generated method stub
		return("123");
	}
	
	public BuilderConnection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}


}
