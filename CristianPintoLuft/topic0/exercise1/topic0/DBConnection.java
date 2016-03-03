package topic0;

public class DBConnection {
	private static DBConnection dbConnection = null;

	private DBConnection() {
	}

	public static DBConnection getInstance() {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}
