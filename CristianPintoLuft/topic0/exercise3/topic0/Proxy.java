package topic0;

public class Proxy {
	JDBCAccesor jdbcAccesor;

	public Proxy() {
	}

	public void sayHello() {
		if (jdbcAccesor == null) {
			jdbcAccesor = new JDBCAccesor();
		}
		jdbcAccesor.sayHello();
	}
}
