package topic0EJ4;

public class BDBuilder {
	
	//required
	private String URL ;
	private String User ;
	private String Pass;
	
	//optional
	private String Description;
	
	public BDBuilder (String URL, String User, String Pass){
		this.URL = URL;
		this.User = User;
		this.Pass = Pass;
	}
	
	public BDBuilder setDescription (String description){
		this.Description = description;
		return this;
	}
	
	public String getURL () {
		return URL;
	}
	
	public String getUser () {
		return User;
	}
	
	public String getPass () {
		return Pass;
	}
	
	public String getDescription () {
		return Description;
	}
	
	public DB build() {
		// TODO Auto-generated method stub
		return new DB (this);
	}

	public String toString() {

		return "URL: " + URL + " - User: " + User + " - Pass: " + Pass + " - Description: " + Description;
	}
	
	
}
