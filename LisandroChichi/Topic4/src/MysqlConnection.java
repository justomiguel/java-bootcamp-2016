import java.sql.*;

public class MysqlConnection {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/high-school";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//  Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select high_priority t.first_name,t.last_name, cs.day, cs.hour, c.name_course "
					+ "from teacher t, course_schedule cs,course c where cs.id_course = 1 "
					+ "and c.id_course = cs.id_course and t.id_teacher = c.teacher_assigned";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String firstName = rs.getString("t.first_name");
				String lastName = rs.getString("t.last_name");
				String day = rs.getString("cs.day");
				String hour = rs.getString("cs.hour");
				String name_course = rs.getString("c.name_course");

				// Display values
				System.out.print("\n First Name: " + firstName);
				System.out.print("\n Last Name: " + lastName);
				System.out.print("\n Day: " + day);
				System.out.println("\n Hour: " + hour);
				System.out.println(" Name course: " + name_course);
			}
			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}
}