package topic0.Exercise1;

/**
 * Mock for Connection from DriverManager.getConnection(stringConnection)
 * @author cactus
 *
 */
public class MockConnection {
	private String driver;
	private String database;
	private String databaseName;
	private String password;
	
	public MockConnection(String d, String db, String dbname, String p) {
		this.setDriver(d);
		this.setDatabase(db);
		this.setDatabaseName(dbname);
		this.setPassword(p);
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public  String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
