package topic0EJ4;

public class BD2Builder {

private BDBuilder bdBuilder;
	
	public BD2Builder (){
		bdBuilder = new BDBuilder ("http://www.database2.com", "User2", "54321");
	}
	
	public String setDescription (){
		return("A little description for Database 2") ;
	}
	
	public String getDB (){
		return bdBuilder.toString();
	}
	
	public String getURL () {
		return bdBuilder.getURL();
	}
	
	public String getUser () {
		return bdBuilder.getUser();
	}
	
	public String getPass () {
		return bdBuilder.getPass();
	}

}
