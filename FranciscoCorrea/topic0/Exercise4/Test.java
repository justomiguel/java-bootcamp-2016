package lala;


public class Test {

	public static void main(String[] args) {
		Connection var = new Connection.ConnectionBuilder("dri", 8080, "mysql", "xfiles")
				.password("passwordfalsa123")
				.buildConnection();
		
		System.out.println(var.getDatabase());
	}

}
