package SingletonConnectionDatabase;

public class Main {

	public static void main(String[] args) {
		
		// many instances but only works one
		ConnectionDatabase con = ConnectionDatabase.getInstance();
		ConnectionDatabase con1 = ConnectionDatabase.getInstance();
		ConnectionDatabase con2 = ConnectionDatabase.getInstance();
	}
}
