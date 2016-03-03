	package topic0EJ4;

public class DB {
	private String URL ;
	private String User ;
	private String Pass;
	private String Description;
	
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
			Description = description;
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

		
	}
	
	DB (topic0EJ4.BDBuilder bdBuilder){
		URL = bdBuilder.getURL();
		User = bdBuilder.getUser();
		Pass = bdBuilder.getPass();
		Description = bdBuilder.getDescription();
	}
	
	public String toString() {
		return "URL:" + URL + ", User:" + User + ", Pass:" + Pass+ ", Description:" + Description;
	}
}
