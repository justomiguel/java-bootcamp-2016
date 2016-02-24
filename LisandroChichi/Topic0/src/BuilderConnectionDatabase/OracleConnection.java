package BuilderConnectionDatabase;

public class OracleConnection implements BuilderConnection{

	Connection conn;
	
	
	public OracleConnection() {
		// TODO Auto-generated constructor stub
	conn = new Connection();
	
	}
	
	public void createDriver() {
		// TODO Auto-generated method stub
		conn.setDriver("oracle.jdbc.driver.OracleDriver");
	}

	@Override
	public void createUrl() {
		// TODO Auto-generated method stub
		conn.setUrl("jdbc:oracle:thin:@localhost:1521:scorpian");

	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		conn.setUser("userName");

	}

	@Override
	public void createPass() {
		// TODO Auto-generated method stub
		conn.setPass("pass");

	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}

}
