package AbstractFactoryConnectionPool;

public class PostgresqlConnection extends Connection{

	public PostgresqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Postgresql Connection";
	}
}
