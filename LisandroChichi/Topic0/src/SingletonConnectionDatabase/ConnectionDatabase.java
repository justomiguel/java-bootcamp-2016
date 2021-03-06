package SingletonConnectionDatabase;
public final class ConnectionDatabase {
	private static ConnectionDatabase instance = null;

	private ConnectionDatabase() {
		System.out.println("Connection done!");

	}
	// thread-safe Connection
	public static ConnectionDatabase getInstance() {
		if (instance == null) {

			synchronized (ConnectionDatabase.class) {

				if (instance == null) {
					instance = new ConnectionDatabase();
				}
			}
		}
		return instance;
	}
}