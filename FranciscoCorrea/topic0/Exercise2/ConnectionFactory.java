package topic0.Exercise2;

public class ConnectionFactory extends AbstractFactory{

	@Override
	public Connection getConnection(String connection) {
		
		if (connection == null) {
			return null;
		}
		
		if (connection.equalsIgnoreCase("POSTGRE")) {
			return new PostgreConnection();
		}
		if (connection.equalsIgnoreCase("MYSQL")) {
			return new MysqlConnection();
		}
		if (connection.equalsIgnoreCase("ORACLE")) {
			return new OracleConnection();
		}
		
		return null;
		
	}

}
