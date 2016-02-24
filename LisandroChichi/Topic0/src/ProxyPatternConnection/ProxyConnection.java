package ProxyPatternConnection;

public class ProxyConnection implements ConnectionManager{
	

	RealConnection real = new RealConnection();
	@Override
	public void dataBaseConnection() {
		
		real.dataBaseConnection();
		
	}

	@Override
	public void CreateQuery() {
		
		real.CreateQuery();
		
	}
	
	
}
