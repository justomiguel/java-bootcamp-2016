package AbstractFactoryConnectionPool;

public abstract class AbstractFactory {

	public AbstractFactory() {
		// TODO Auto-generated constructor stub
	}	
	
	protected abstract Connection startConnection(String typeConnection);
	
}
