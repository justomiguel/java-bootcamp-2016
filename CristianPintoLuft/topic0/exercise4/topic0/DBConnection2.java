package topic0;

public class DBConnection2 {
	private String connectionName;
	private String username;
	private String password;

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Connection name: " + connectionName + ", username: " + username 
				+ ", password: " + password;
	}

}
