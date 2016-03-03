package BuilderConnectionDatabase;

public class MainConnection {

	public static void main(String[] args) {

		MySqlConnection mysql = new MySqlConnection();

		Connection conn = new Connection.BuilderConnection()
				.createDriver(mysql.createDriver())
				.createUrl(mysql.createUrl())
				.createUser(mysql.createUser())
				.createUrl(mysql.createUrl())
				.build();

		System.out.println(conn);
	}

}
