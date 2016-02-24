package topic0.Exercise4;

public class Test {

	public static void main(String[] args) {
		ConnectionBuilder connBuilder = new PostgreBuilder();
		ConnectionDirector director = new ConnectionDirector(connBuilder);
		
		director.buildConnection();
		Connection conn = director.getConnection();
		
		System.out.println(conn.getDatabase());
	}

}
