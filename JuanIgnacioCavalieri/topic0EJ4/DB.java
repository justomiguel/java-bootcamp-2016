package topic0EJ4;

public class DB {
	private String URL ;
	private String User ;
	private String Pass;
	
	public String GetURL (){
		return URL;
	}
	
	public String GetUser (){
		return User;
	}
	
	public String GetPass (){
		return Pass;
	}
	
	public void SetURL (String URL){
		this.URL = URL;
	}
	
	public void SetUser (String User){
		this.User = User;
	}
	
	public void SetPass (String Pass){
		this.Pass = Pass;
	}
	
	public String toString() {
		return "URL:" + URL + ", User:" + User + ", Pass:" + Pass;
	}
}
