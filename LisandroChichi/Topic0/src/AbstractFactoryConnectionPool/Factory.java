package AbstractFactoryConnectionPool;

public class Factory extends AbstractFactory{
	
	public Factory() {
		// TODO Auto-generated constructor stub
	}
	public Connection startConnection (String typeConnection){
	if (typeConnection.equals("MySql")){
		return new MySqlConnection();
	}
	else if (typeConnection.equals("Oracle")){
		return new OracleConection();
	}
	else if (typeConnection.equals("Postgresql")){
		return new PostgresqlConnection();
	}
	return null;	
	}
	
}
