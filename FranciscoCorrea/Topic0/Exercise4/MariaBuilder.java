package topic0.Exercise4;

public class MariaBuilder implements ConnectionBuilder {
	
	private Connection conn;
	
	public MariaBuilder() {
		this.conn = new Connection();
	}
	
	@Override
	public void buildDriver() {
		this.conn.setDriver("org.mariadb.driver");
		
	}

	@Override
	public void buildDatabase() {
		this.conn.setDatabase("MariaDB");
		
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
