package topic0.Exercise4;

public class Connection {
	private final String driver;
	private final int ip;
	private final String database;
	private final String dbname;
	private final String password;
	
	public String getDriver() { return this.driver; }
	public int getIp() { return this.ip; }
	public String getDatabase() {return this.database; }
	public String getDbName() { return this.dbname; }
	public String getPassword() { return this.password; }
	
	private Connection(ConnectionBuilder builder) {
		this.driver = builder.driver;
		this.ip = builder.ip;
		this.database = builder.database;
		this.dbname = builder.dbname;
		this.password = builder.password;
	}
	
	public static class ConnectionBuilder {
		private final String driver;
		private final int ip;
		private final String database;
		private final String dbname;
		private String password;
		
		public ConnectionBuilder(String d, int ip, String db, String dbname) {
			this.driver = d;
			this.ip = ip;
			this.database = db;
			this.dbname = dbname;
		}
		
		public ConnectionBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public Connection buildConnection() {
			return new Connection(this);
		}
		
	}
	
}
