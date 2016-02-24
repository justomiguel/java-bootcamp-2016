package topic0EJ1;

public class Mocks  {
	
	public static void ComprobarConexion (String URL, String User, String Pass) {

		//Control URL
		if (URL == "http://www.testurl.com"){
					
			//Control USER
			if (User == "UserTest"){
						
				//Control PASS
				if (Pass == "12345"){
					System.out.println("Conexión exitosa");
				}else{
					System.out.println("Error en contraseña");
				}//end control pass
						
			}else{
				System.out.println("Error en el nombre de usuario");
			}//end control user
					
		}else{
			System.out.println("Error en la dirección URL");
		}//end control conectar
	}
	
}
