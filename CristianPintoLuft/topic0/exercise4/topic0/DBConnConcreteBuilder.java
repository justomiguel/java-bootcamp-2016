package topic0;

public class DBConnConcreteBuilder implements DBConnBuilder {
	private DBConn dbConn;

	final String dbName;
	final String dbIP;
	final int dbPort;
	final String userName;
	final String password;
	String comments;

	public DBConnConcreteBuilder(String dbName, String dbIP, int dbPort, 
			String userName, String password) {
		this.dbName = dbName;
		this.dbIP = dbIP;
		this.dbPort = dbPort;
		this.userName = userName;
		this.password = password;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public void buildDBConn() {
		dbConn = new DBConn(this);
	}

	@Override
	public DBConn getDBConn() {
		return dbConn;
	}

}
