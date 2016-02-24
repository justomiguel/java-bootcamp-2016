package topic0.Exercise4;

public class PostgreBuilder implements ConnectionBuilder {

	private Connection conn;
	
	public PostgreBuilder() {
		this.conn = new Connection();
	}
	
	@Override
	public void buildDriver() {
		this.conn.setDriver("org.postgre.driver");
	}

	@Override
	public void buildDatabase() {
		this.conn.setDatabase("postgre");
	}

	@Override
	public void buildDatabaseName() {
		this.conn.setDbname("xfiles");
	}

	@Override
	public Connection getConnection() {
		return this.conn;
	}

}
