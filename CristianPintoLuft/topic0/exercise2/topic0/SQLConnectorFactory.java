package topic0;

public class SQLConnectorFactory extends AbstractFactory {

	@Override
	SQLConnector getSQLConnector(String sqlConnectorType) {
		if (sqlConnectorType == null) {
			return null;
		} else if (sqlConnectorType.equalsIgnoreCase("MYSQLCONNECTOR")) {
			return new MySQLConnector();
		} else if (sqlConnectorType.equalsIgnoreCase("POSTGRESQLCONNECTOR")) {
			return new PostgreSQLConnector();
		} else if (sqlConnectorType.equalsIgnoreCase("SQLSERVERCONNECTOR")) {
			return new SQLServerConnector();
		}
		return null;
	}
}
