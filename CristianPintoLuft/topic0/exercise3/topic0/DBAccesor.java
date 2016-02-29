package topic0;

public abstract class DBAccesor {
	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " says hello!");
	}
}
