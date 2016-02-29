package topic0EJ3;

import java.util.Date;

public class Proxy {
	DataBaseSecond BD2;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void show() {
		if (BD2 == null) {
			BD2 = new DataBaseSecond();
		}
	}
}
