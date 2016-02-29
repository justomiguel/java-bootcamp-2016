package topic0;

public class DBConn {
	private final String dbName;
	private final String dbIP;
	private final int dbPort;
	private final String userName;
	private final String password;
	private final String comments;

	DBConn(DBConnConcreteBuilder dbConnConcreteBuilder) {
		this.dbName = dbConnConcreteBuilder.dbName;
		this.dbIP = dbConnConcreteBuilder.dbIP;
		this.dbPort = dbConnConcreteBuilder.dbPort;
		this.userName = dbConnConcreteBuilder.userName;
		this.password = dbConnConcreteBuilder.password;
		this.comments = dbConnConcreteBuilder.comments;
	}

	public String getDbName() {
		return dbName;
	}

	public String getDbIP() {
		return dbIP;
	}

	public int getDbPort() {
		return dbPort;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getComments() {
		return comments;
	}

	public String toString() {
		return "DB name: " + dbName + ", IP: " + dbIP + ", port: " + dbPort + 
				", username: " + userName + ", password: " + password
				+ ", comments (if anything): " + comments;
	}
}
