package topic0EJ4;

public class BD1Builder implements BDBuilder{
	private DB db;
	
	public BD1Builder (){
		db = new DB();
	}

	@Override
	public void BuildURL() {
		// TODO Auto-generated method stub
		db.SetURL("http://www.database1.com");
		
	}

	@Override
	public void BuildUser() {
		// TODO Auto-generated method stub
		db.SetUser("User1");
		
	}

	@Override
	public void BuildPass() {
		// TODO Auto-generated method stub
		db.SetPass("12345");
		
	}

	@Override
	public DB GetDB() {
		// TODO Auto-generated method stub
		return db;
	}
}
