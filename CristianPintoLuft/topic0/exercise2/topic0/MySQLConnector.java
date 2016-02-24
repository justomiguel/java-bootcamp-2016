package topic0;

public class MySQLConnector implements SQLConnector {

	@Override
	public void connect() {
		System.out.println("Connecting with MySQL connector");
	}

}
