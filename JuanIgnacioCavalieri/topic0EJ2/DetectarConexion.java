package topic0EJ2;

public class DetectarConexion {
	public static FactoryExample GetTipo (String Tipo){

		if (Tipo == "MySQL"){
			return new MySQL();
		}else if (Tipo == "Oracle"){
			return new Oracle();
		}else if (Tipo == "PostgresSQL"){
			return new PostgresSQL();
		}else{
			return null;
		}

	}
}
