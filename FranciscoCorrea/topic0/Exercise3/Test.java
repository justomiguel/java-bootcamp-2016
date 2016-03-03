package topic0.Exercise3;

public class Test {

	public static void main(String[] args) {
		ExampleDAO proxy = new ProxyExampleDAO();
		proxy.delete(1000);
	}

}
