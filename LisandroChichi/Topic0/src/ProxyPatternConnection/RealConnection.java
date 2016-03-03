package ProxyPatternConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class RealConnection implements ConnectionManager{
	Connection myConn;
	@Override
	public void dataBaseConnection() {
		System.out.println("has been connected to MySql database");
		String url = "jdbc:mysql://localhost/tiger";
		
		String user ="root";
		String password="root";
		try {
			myConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void CreateQuery() {
		Statement myState;
		try {
			myState = myConn.createStatement();
			ResultSet rs = myState.executeQuery("select * FROM employees");
			rs.getClass();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void HideInformation() throws SQLException
	{
		System.out.println("this information can't be accessed, you can die!");
		myConn.getClientInfo();
		myConn.hashCode();
		
	}
	
	
	
	
}
