package topic0EJ2;

public class Index {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FactoryExample Opcion1 = DetectarConexion.getTipo("MySQL");
		System.out.println("Opcion 1: " + Opcion1.tipoConexion());
		
		FactoryExample Opcion2 = DetectarConexion.getTipo("Oracle");
		System.out.println("Opcion 2: " + Opcion2.tipoConexion());
		
		FactoryExample Opcion3 = DetectarConexion.getTipo("PostgresSQL");
		System.out.println("Opcion 3: " + Opcion3.tipoConexion());
	}

}
