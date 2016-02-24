package topic0EJ4;

public class BD2Builder implements BDBuilder{

	private DB db;
	
	public BD2Builder (){
		db = new DB();
	}
	
	@Override
	public void BuildURL() {
		// TODO Auto-generated method stub
		db.SetURL("http://www.database2.com");
		
	}

	@Override
	public void BuildUser() {
		// TODO Auto-generated method stub
		db.SetUser("User2");
		
	}

	@Override
	public void BuildPass() {
		// TODO Auto-generated method stub
		db.SetPass("54321");
		
	}

	@Override
	public DB GetDB() {
		// TODO Auto-generated method stub
		return db;
	}

}
