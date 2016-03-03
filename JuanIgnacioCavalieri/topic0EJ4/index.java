package topic0EJ4;

public class index {
	public static void main(String[] args) {

		BDBuilder dbBuilder = new BD1Builder();
		BDDirector dbDirector = new BDDirector(dbBuilder);
		dbDirector.constructBD();
		DB db = dbDirector.getDB();
		System.out.println("Los datos de la base de datos son : " + db);
		
		BDBuilder dbBuilder2 = new BD2Builder();
		BDDirector dbDirector2 = new BDDirector(dbBuilder2);
		dbDirector2.constructBD();
		DB db2 = dbDirector2.getDB();
		System.out.println("Los datos de la base de datos son : " + db2);
		
		
	}
}
