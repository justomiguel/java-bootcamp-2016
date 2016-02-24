package BuilderConnectionDatabase;

public class DirectorConnection {

	BuilderConnection builder;

	public void setBuilder(BuilderConnection builder) {
		this.builder = builder;
	}
	
	public Connection getConnection(){
		return builder.getConnection();
	}
	
	public void constructConnection(){
		builder.createConnection();
		builder.createDriver();
		builder.createUrl();
		builder.createUser();
		builder.createPass();
	}
	
}
