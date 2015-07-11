package org.myhonor.tinystar.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.myhonor.tinystar.entity.UserInfo;

public class DbHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://127.0.0.1:3306/home";
	private static String url = "jdbc:mysql://localhost:3306/homeland";
	private static String user = "mysql";
	private static String password = "mysql";

	public static boolean authenUserInfo(UserInfo userInfo) {
		String username=userInfo.getUsername();
		String password=userInfo.getPassword();
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return false;
		}
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement statement = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user,
					password);
			// if (!conn.isClosed())
			// statement = conn.createStatement();
			String sql = "select 1 from userinfo where username= ? and password= ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			boolean isExist = (null != rs && rs.next());
			if (isExist) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			}

			catch (Exception e) {

			}
		}
	}

}
