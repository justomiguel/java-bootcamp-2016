package topic0;

public class Demo {

	public static void main(String[] args) {
		DBConnection2Builder dbConnection2Builder = new MySQLDBConnection2Builder();
		DBConnection2Director dbConnection2Director = new DBConnection2Director(dbConnection2Builder);

		dbConnection2Director.constructDBConnection2();
		DBConnection2 dbConnection2 = dbConnection2Director.getDBConnection2();
		System.out.println("DBConnection is: " + dbConnection2);

		dbConnection2Builder = new PostgreSQLConnection2Builder();
		dbConnection2Director = new DBConnection2Director(dbConnection2Builder);

		dbConnection2Director.constructDBConnection2();
		dbConnection2 = dbConnection2Director.getDBConnection2();
		System.out.println("DBConnection is: " + dbConnection2);
	}

}
