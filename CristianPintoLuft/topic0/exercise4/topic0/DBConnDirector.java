package topic0;

public class DBConnDirector {
	private DBConnBuilder dbConnBuilder;

	public DBConnDirector(DBConnBuilder dbConnBuilder) {
		this.dbConnBuilder = dbConnBuilder;
	}

	public void constructDBConn() {
		dbConnBuilder.buildDBConn();
	}

	public DBConn getDBConn() {
		return dbConnBuilder.getDBConn();
	}
	
	public void setDBConnComments(String comments)
	{
		dbConnBuilder.setComments(comments);
	}
}
