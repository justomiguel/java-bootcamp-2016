package topic0EJ2;

public class DetectarConexion {
	public static FactoryExample getTipo (String Tipo){

		if (Tipo.equals("MySQL")){
			return new MySQL();
		}else if (Tipo.equals("Oracle")){
			return new Oracle();
		}else if (Tipo.equals("PostgresSQL")){
			return new PostgresSQL();
		}else{
			return null;
		}

	}
}
