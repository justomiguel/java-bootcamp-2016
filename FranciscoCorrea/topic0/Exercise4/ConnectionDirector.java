package topic0.Exercise4;

public class ConnectionDirector {
	
	private ConnectionBuilder connectionBuilder = null;
	
	public ConnectionDirector(ConnectionBuilder connectionBuilder) {
		this.connectionBuilder = connectionBuilder;
	}
	
	public void buildConnection() {
		this.connectionBuilder.buildDriver();
		this.connectionBuilder.buildDatabase();
		this.connectionBuilder.buildDatabaseName();	
	}
	
	public Connection getConnection() {
		return this.connectionBuilder.getConnection();
	}
}
