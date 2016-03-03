package topic0EJ1;

public class SingletonExample  {
	
	private String URL ;
	private String User ;
	private String Pass;
	private static SingletonExample EstadoConexion;
	
	//Obtener estado
	public static SingletonExample GetState (String URL, String User, String Pass){
		if (EstadoConexion == null){
			EstadoConexion = new SingletonExample (URL,User,Pass);
		}
		
		return EstadoConexion;
	}
	
	//Constructor
	private SingletonExample (String URL, String User, String Pass){
		Mocks.ComprobarConexion(URL, User, Pass);
	}
	
	public String GetURL (){
		return URL;
	}
	
	public String GetUser (){
		return User;
	}
	
	public String GetPass (){
		return Pass;
	}
	
	public void SetURL (String URL){
		this.URL = URL;
	}
	
	public void SetUser (String User){
		this.User = User;
	}
	
	public void SetPass (String Pass){
		this.Pass = Pass;
	}
}
