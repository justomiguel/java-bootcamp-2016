package topic0;

public class DBConnectionDemo {

	public static void main(String[] args) {
		DBConnection dbConnection = DBConnection.getInstance();
		dbConnection.sayHello();
	}

}
