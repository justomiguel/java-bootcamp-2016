package AbstractFactoryConnectionPool;

public class Factory extends AbstractFactory{
	
	public Factory() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection startConnection (String typeConnection){
		switch (typeConnection) {
		case "MySql":
			return new MySqlConnection();
		case "Oracle":
			return new OracleConection();
		case "Postgresql":
			return new PostgresqlConnection();
		default:
			
			break;
		}
		
		return null;
	}
}