package topic0EJ4;

import topic0EJ4.BDBuilder;


public class BD1Builder {
	
	private BDBuilder bdBuilder;
	
	public BD1Builder (){
		bdBuilder = new BDBuilder ("http://www.database.com", "User", "12345");
	}
	
	public String setDescription (){
		return("A little description for Database 1") ;
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
