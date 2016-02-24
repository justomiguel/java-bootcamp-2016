package BuilderConnectionDatabase;

public class MainConnection {

	public static void main(String[] args) {
				
		DirectorConnection director = new DirectorConnection();
		
		BuilderConnection connection = new OracleConnection();
		
		connection.createConnection();
		director.setBuilder(connection);
		
		director.constructConnection();
		
		Connection completeConnection = director.getConnection();
		
		System.out.println("Connection Driver: "+completeConnection.getDriver() 
				+"\nConnection Password: "+completeConnection.getPass());
		
	}
	
}