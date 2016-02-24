package topic0.Exercise1;

public class ConnectToDB {
	private static ConnectToDB instance = null;
	private static MockConnection connection = null;
	
	private ConnectToDB() {
		connection = new MockConnection("","","","");
	}
	
	public static ConnectToDB getInstance(){
		if(instance == null) {
			instance = new ConnectToDB();
		}
		return instance;
	}
}
