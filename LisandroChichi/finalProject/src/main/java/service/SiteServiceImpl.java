package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import config.HibernateConnection;
import entity.User;

public class SiteServiceImpl implements SiteService {

	private HibernateConnection hc;
	
	@Override
	public boolean login(User user) {
		boolean userAvailable = false;

		try {

			Statement stmt = (Statement) hc.dataSource().getConnection()
					.createStatement();
			String query = "SELECT * FROM user WHERE username = '" + user.getName()
					+ "' AND password=" + "'" + user.getPassword() + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				userAvailable = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userAvailable;
	}

}
