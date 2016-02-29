package topic0EJ1;

public class Index {
	//Variables utilizadas
	public String EjemploConexion;
	
	//Prueba de Singleton
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonExample.setConnection("http://www.testurl.com", "UserTest", "12345");
		System.out.println(Mocks.getConnection());;
	}
	
	

}
