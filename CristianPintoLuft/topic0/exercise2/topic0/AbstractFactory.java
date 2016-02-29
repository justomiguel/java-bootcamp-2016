package topic0;

public abstract class AbstractFactory {
	abstract SQLConnector getSQLConnector(String sqlConnector);
}
