package topic0;

public class DBConnection2Director {
	private DBConnection2Builder dbConnection2Builder;

	public DBConnection2Director(DBConnection2Builder dbConnection2Builder) {
		this.dbConnection2Builder = dbConnection2Builder;
	}

	public void constructDBConnection2() {
		dbConnection2Builder.buildConnection();
		dbConnection2Builder.buildUsername();
		dbConnection2Builder.buildPassword();
	}

	public DBConnection2 getDBConnection2() {
		return dbConnection2Builder.getDBConnection2();
	}
}
