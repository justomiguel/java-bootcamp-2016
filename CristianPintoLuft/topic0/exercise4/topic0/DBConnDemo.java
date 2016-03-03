package topic0;

public class DBConnDemo {

	public static void main(String[] args) {
		//Building a MySQL connection (withouth comments)
		String dbName = "MySQL";
		String dbIP = "192.168.1.2";
		int dbPort = 3306;
		String userName = "cristianpl";
		String password = "admin123";
		DBConnBuilder dbConnBuilder = new DBConnConcreteBuilder(dbName, dbIP, 
				dbPort, userName, password);
		DBConnDirector dbConnDirector = new DBConnDirector(dbConnBuilder);
		dbConnDirector.constructDBConn();
		System.out.println(dbConnDirector.getDBConn());
		
		//Building a PostgreSQL connection (with comments)
		dbName = "PostgreSQL";
		dbIP = "192.168.1.3";
		dbPort = 3307;
		userName = "cristianpl";
		password = "admin123";
		String comments = "Administrative database";
		dbConnBuilder = new DBConnConcreteBuilder(dbName, dbIP, dbPort, 
				userName, password);
		dbConnDirector = new DBConnDirector(dbConnBuilder);
		dbConnDirector.setDBConnComments(comments);
		dbConnDirector.constructDBConn();
		System.out.println(dbConnDirector.getDBConn());
	}

}
