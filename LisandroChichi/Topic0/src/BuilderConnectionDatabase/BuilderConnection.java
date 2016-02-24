package BuilderConnectionDatabase;

public interface BuilderConnection {

	public void createDriver();
	public void createUrl();
	public void createUser();
	public void createPass();
	public Connection getConnection();
	

}
