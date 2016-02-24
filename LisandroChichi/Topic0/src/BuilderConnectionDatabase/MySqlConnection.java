package BuilderConnectionDatabase;

public class MySqlConnection implements BuilderConnection{

	private Connection conn;
	
	public MySqlConnection() {
		conn = new Connection();
	}
	
	@Override
	public void createDriver() {
		// TODO Auto-generated method stub
		conn.setDriver("org.gjt.mm.mysql.Driver");	
	}

	@Override
	public void createUrl() {
		// TODO Auto-generated method stub
		conn.setUrl("jdbc:mysql://localhost/tiger");

	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		conn.setUser("root");

	}

	@Override
	public void createPass() {
		// TODO Auto-generated method stub
		conn.setPass("root");

	}

	@Override
	public Connection getConnection() {
		return conn;
	}

	
}
