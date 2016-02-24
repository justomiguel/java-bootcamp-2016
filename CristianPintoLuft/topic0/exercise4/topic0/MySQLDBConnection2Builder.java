package topic0;

public class MySQLDBConnection2Builder implements DBConnection2Builder {

	private DBConnection2 dbConnection2;

	public MySQLDBConnection2Builder() {
		dbConnection2 = new DBConnection2();
	}

	@Override
	public void buildConnection() {
		dbConnection2.setConnectionName("MySQL");

	}

	@Override
	public void buildUsername() {
		dbConnection2.setUsername("cosme");

	}

	@Override
	public void buildPassword() {
		dbConnection2.setPassword("fulanito");

	}

	@Override
	public DBConnection2 getDBConnection2() {
		return dbConnection2;
	}

}
