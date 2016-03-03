package topic0;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		AbstractFactory sqlConnectorFactory = FactoryProducer.getFactory("SQLCONNECTORFACTORY");
		SQLConnector mySQLConnector = sqlConnectorFactory.getSQLConnector("MYSQLCONNECTOR");

		SQLConnector postgreSQLConnector = sqlConnectorFactory.getSQLConnector("POSTGRESQLCONNECTOR");

		SQLConnector sqlServerConnector = sqlConnectorFactory.getSQLConnector("SQLSERVERCONNECTOR");

		mySQLConnector.connect();
		postgreSQLConnector.connect();
		sqlServerConnector.connect();
	}

}
