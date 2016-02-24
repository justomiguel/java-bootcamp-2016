package topic0;

public class ProxyDemo {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();

		ODBCAccesor odbcAccesor = new ODBCAccesor();
		odbcAccesor.sayHello();

		proxy.sayHello();
	}

}
