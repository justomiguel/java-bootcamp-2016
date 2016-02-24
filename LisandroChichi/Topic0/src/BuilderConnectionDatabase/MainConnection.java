package BuilderConnectionDatabase;

public class MainConnection {

	public static void main(String[] args) {
				
		
		BuilderConnection builder = new MySqlConnection();
		DirectorConnection director = new DirectorConnection(builder);
		
		
		director.constructConnection();
		
		Connection conn = director.getConnection();
		
		System.out.println("Connection Driver: "+conn.driver );
		
		
		BuilderConnection builder2 = new OracleConnection();
		DirectorConnection director2 = new DirectorConnection(builder2);
		
		
		director2.constructConnection();
		
		Connection conn2 = director2.getConnection();
		
		System.out.println("Connection Driver: "+conn2.driver );
		
	}
	
}
