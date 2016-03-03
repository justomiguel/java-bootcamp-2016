package topic0.Exercise2;

public class FactoryProducer {
	public static AbstractFactory getFactory() {
		return new ConnectionFactory();
	}
}
