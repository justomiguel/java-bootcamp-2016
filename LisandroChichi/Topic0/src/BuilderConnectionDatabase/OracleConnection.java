package BuilderConnectionDatabase;

import BuilderConnectionDatabase.Connection.BuilderConnection;

public class OracleConnection {

	private BuilderConnection conn;

	public OracleConnection() {
		// TODO Auto-generated constructor stub
		conn = new BuilderConnection();

	}

	public String createDriver() {
		// TODO Auto-generated method stub
		return("oracle.jdbc.driver.OracleDriver");
	}

	public String createUrl() {
		// TODO Auto-generated method stub
		return("jdbc:oracle:thin:@localhost:1521:scorpian");

	}

	public String createUser() {
		// TODO Auto-generated method stub
		return("userName");

	}

	public String createPass() {
		// TODO Auto-generated method stub
		return("pass");

	}

	public BuilderConnection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}

}
