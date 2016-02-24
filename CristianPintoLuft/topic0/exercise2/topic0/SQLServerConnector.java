package topic0;

public class SQLServerConnector implements SQLConnector {

	@Override
	public void connect() {
		System.out.println("Connecting with SQLServer connector");
	}

}
