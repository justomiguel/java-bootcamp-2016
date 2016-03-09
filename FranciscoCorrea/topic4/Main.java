import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectToDB.connect();
		String query = 
			"SELECT HIGH_PRIORITY " +
			"t.last_name, t.first_name, sch.day, sch.hour_in, " + 
			" sch.hour_out, c.name " +
			"FROM teacher AS t " +
			"INNER JOIN course AS c ON t.id = c.assigned_teacher " +
			"INNER JOIN schedule_time as sch ON c.id = sch.course " +
			"WHERE t.id = 3 " +
			"ORDER BY FIELD(sch.day, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes');";
		
		ResultSet rs = ConnectToDB.getQuery(query, connection);
		rs.first();
		
		System.out.println("Teacher: " + rs.getString("last_name"));
		System.out.println("Schedule:");
		
		rs.previous();
		
		while (rs.next()) {
			System.out.println("\t" + rs.getString("day")
					+ " " + rs.getTime("hour_in") 
					+ " - " + rs.getTime("hour_out")
					+ " " + rs.getString("name")
				);
		}
	}

}
