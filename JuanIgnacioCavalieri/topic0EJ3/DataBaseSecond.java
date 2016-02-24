package topic0EJ3;

public class DataBaseSecond extends DataBase {
	public DataBaseSecond() {
		try {
			Thread.sleep(2000);
			System.out.println("Acceso a base de datos secundaria a la hora " + DataBase.ShowDate());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
