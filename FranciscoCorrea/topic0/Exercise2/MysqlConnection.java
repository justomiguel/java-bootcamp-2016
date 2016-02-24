package topic0.Exercise2;

public class MysqlConnection implements Connection{

	@Override
	public void connect() {
		System.out.println("Connecting to MySql... ");
	}

}
