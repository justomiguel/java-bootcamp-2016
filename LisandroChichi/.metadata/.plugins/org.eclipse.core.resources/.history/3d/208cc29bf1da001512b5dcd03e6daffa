package BuilderConnectionDatabase;

public abstract class BuilderConnection {

	Connection conn;
	String driver;
	String url;
	String user;
	String pass;
	
	public Connection getConnection(){
		return conn;
	}
	
	public void createConnection(){
		conn = new Connection(driver, url, user, pass);
	}
	public abstract void createDriver();
	public abstract void createUrl();
	public abstract void createUser();
	public abstract void createPass();

}
