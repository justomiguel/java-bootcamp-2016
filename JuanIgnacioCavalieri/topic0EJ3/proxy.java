package topic0EJ3;

import java.util.Date;

public class proxy {
	DataBaseSecond BD2;

	public proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void show() {
		if (BD2 == null) {
			BD2 = new DataBaseSecond();
		}
	}
}
