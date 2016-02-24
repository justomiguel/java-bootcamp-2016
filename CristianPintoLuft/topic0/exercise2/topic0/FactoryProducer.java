package topic0;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SQLCONNECTORFACTORY")) {
			return new SQLConnectorFactory();
		} else
			return null;
	}
}
