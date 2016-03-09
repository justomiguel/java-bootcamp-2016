import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mariadb://localhost/high_school", "root", "731013912aix");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static ResultSet getQuery(String query, Connection conn) throws SQLException {
		ResultSet rs = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(query);
		return rs;
	}
}
