package AbstractFactoryConnectionPool;

import java.util.Scanner;

public class MainConnectionPool {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Factory factory = new Factory();
		Connection conn;
		
		System.out.print("Select the database to connect - MySql, Oracle, Postgresql");
		String type = sc.nextLine();
		conn = factory.startConnection(type);
		String salida = "You are connected with "+ conn.descripcion();
		System.out.println(salida);
	}
}
