package BuilderConnectionDatabase;

public class Connection {
	private final String driver;
	private final String url;
	private final String user;
	private final String pass;

	
	public Connection(BuilderConnection buider) {
		this.driver = buider.driver;
		this.url = buider.url;
		this.user = buider.user;
		this.pass = buider.pass;
	}
	public static class BuilderConnection {

		private  String driver;
		private  String url;
		private  String user;
		private  String pass;
		
		
		public BuilderConnection createDriver(String driver) {
			this.driver = driver;
			return this;
		};

		public BuilderConnection createUrl(String url) {
			this.url = url;
			return this;
		};

		public BuilderConnection createUser(String user) {
			this.user = user;
			return this;
		};

		public BuilderConnection createPass(String pass) {
			this.pass = pass;
			return this;
		}

		public Connection build() {
			return new Connection(this);
		}
	}
	
	@Override
	public String toString() {
		return "Driver: " + driver + " - Url: " + url + " - User: " + user + " - Pass: " + pass;
	}
}
