package topic0EJ1;

public class Mocks  {
	
	private static String Msj;

	public static String comprobarConexion (String URL, String User, String Pass) {

		//Control URL
		if (URL == "http://www.testurl.com"){
					
			//Control USER
			if (User == "UserTest"){
						
				//Control PASS
				if (Pass == "12345"){
					Msj = "Conexión exitosa";
				}else{
					Msj = "Error en contraseña";
				}//end control pass
						
			}else{
				Msj = "Error en el nombre de usuario";
			}//end control user
					
		}else{
			Msj = "Error en la dirección URL";
		}//end control conectar
		
		return Msj;
	}
	
		public static String getConnection (){
			String msj;
			if (SingletonExample.EstadoConexion == null){
				msj = "The connection has not been created";
			}else{
				msj = "The connection has been created. Parameters: URL: " + SingletonExample.EstadoConexion.getURL() + ", USER: " + SingletonExample.EstadoConexion.getUser() + ", PASS: " + SingletonExample.EstadoConexion.getPass();
			}
				
			return msj;
		}
	
}
