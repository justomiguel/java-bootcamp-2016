package topic0.Exercise4;

public interface ConnectionBuilder {
	public void buildDriver();
	public void buildDatabase();
	public void buildDatabaseName();
	public Connection getConnection();
}
