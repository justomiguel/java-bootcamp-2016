package topic0EJ2;

public class index {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FactoryExample Opcion1 = DetectarConexion.GetTipo("MySQL");
		System.out.println("Opcion 1: " + Opcion1.TipoConexion());
		
		FactoryExample Opcion2 = DetectarConexion.GetTipo("Oracle");
		System.out.println("Opcion 2: " + Opcion2.TipoConexion());
		
		FactoryExample Opcion3 = DetectarConexion.GetTipo("PostgresSQL");
		System.out.println("Opcion 3: " + Opcion3.TipoConexion());
	}

}
