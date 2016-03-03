package topic0EJ1;

public class SingletonExample  {
	
	private String URL ;
	private String User ;
	private String Pass;
	static SingletonExample EstadoConexion;
	
	//Constructor
	private SingletonExample (String URL, String User, String Pass){
		setURL(URL);
		setUser(User);
		setPass(Pass);
	}
		
	//Crear conexión
	public static SingletonExample setConnection (String URL, String User, String Pass){
		String test;
		if (EstadoConexion == null){
			test = Mocks.comprobarConexion(URL, User, Pass);
			
			if (test.equals("Conexión exitosa")){
				EstadoConexion = new SingletonExample (URL,User,Pass);
			}
			
		}
		
		return EstadoConexion;
	}
	
	public String getURL (){
		return URL;
	}
	
	public String getUser (){
		return User;
	}
	
	public String getPass (){
		return Pass;
	}
	
	public void setURL (String URL){
		this.URL = URL;
	}
	
	public void setUser (String User){
		this.User = User;
	}
	
	public void setPass (String Pass){
		this.Pass = Pass;
	}
}
