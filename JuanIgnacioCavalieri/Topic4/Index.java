package topic4;

/**
 *Main Class Index corresponding to the Topic 4 of Java bootcamp
 *It is used to test MySQL connection and show a specyfic query
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */

import java.sql.DriverManager;
import java.sql.SQLException;


public class Index {

	static java.sql.Connection conexion;
	static Object teacher = new Object();
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Initialize the driver
		try{
		   Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e){
		   e.printStackTrace();
		} 
		
		
		//Stablish the connection to MySQL database
		try {
			conexion = DriverManager.getConnection ("jdbc:mysql://localhost:1408/highschool","root", "12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create a new statement
		java.sql.Statement st = conexion.createStatement();
		
		//Execute the query
		java.sql.ResultSet rs = st.executeQuery("SELECT high_priority Teacher.Last_Name, Teacher.First_Name, Days_Of_Week.DOW_Day, Classes_Of_Week.COW_Hour, Course.Course_Name FROM Classes_Of_Week  INNER JOIN Course ON Course.ID = Classes_Of_Week.COW_Course INNER JOIN Teacher ON Course.Assigned_Teacher = Teacher.DNI INNER JOIN Days_Of_Week ON Days_Of_Week.ID = Classes_Of_Week.COW_Day ORDER BY Teacher.Last_Name, Classes_Of_Week.COW_Day");
		

		//Go throw all the rows and show the information that we need
		System.out.println("Exercise number seven from Topic 4 of Java-bootcamp ");
		System.out.println("");
		while (rs.next()){
			
			if (rs.isFirst()){
				System.out.println("Teacher: " +rs.getObject("Teacher.Last_Name") + ", " + rs.getObject("Teacher.First_Name") );
				System.out.println("Schedule: ");
				teacher = rs.getObject("Teacher.Last_Name");
			}
			
			if (teacher.equals(rs.getObject("Teacher.Last_Name"))){
				System.out.println(rs.getObject("Days_Of_Week.DOW_Day") + " " + rs.getObject("Classes_Of_Week.COW_Hour") + ": " +  rs.getObject("Course.Course_Name"));
			}else{
				System.out.println("");
				System.out.println("Teacher: " +rs.getObject("Teacher.Last_Name") + ", " + rs.getObject("Teacher.First_Name") );
				System.out.println("Schedule: ");
				System.out.println(rs.getObject("Days_Of_Week.DOW_Day") + " " + rs.getObject("Classes_Of_Week.COW_Hour") + ": " +  rs.getObject("Course.Course_Name"));
				teacher = rs.getObject("Teacher.Last_Name");
			}
		}
				
		
			
		
	}

}
