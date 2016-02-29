package BuilderConnectionDatabase;

import BuilderConnectionDatabase.Connection.BuilderConnection;

public class MySqlConnection{

	private BuilderConnection conn;
	
	public MySqlConnection() {
		conn = new BuilderConnection();
	}
	
	public String createDriver() {
		// TODO Auto-generated method stub
		return("org.gjt.mm.mysql.Driver");	
	}

	public String createUrl() {
		// TODO Auto-generated method stub
		return("jdbc:mysql://localhost/tiger");

	}

	public String createUser() {
		// TODO Auto-generated method stub
		return("root");

	}

	public String createPass() {
		// TODO Auto-generated method stub
		return("root");

	}

	public BuilderConnection getConnection() {
		return conn;
	}

	
}
