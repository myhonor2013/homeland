package com.linux.forum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

public class DbHelper
{
	String driver = "com.mysql.jdbc.Driver";
//	String url = "jdbc:mysql://127.0.0.1:3306/home";
	String url = "jdbc:mysql://localhost:3306/homeland";
	String user = "root";
	String password = "myhonor";
	
	public boolean authenUserInfo(String username,String password)
	{
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password))
		{
			return false;
		}
		
		Connection conn=null;
		ResultSet rs =null;
		PreparedStatement statement=null;
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
//			if (!conn.isClosed())
//			statement = conn.createStatement();
			String sql = "select 1 from userinfo where name=? and password=?";
			statement=conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery(sql);
			if (null!=rs&&rs.next())
			{
				return true;
			}
			return false;
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
			return false;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
					rs=null;
				}
				if(statement!=null)
				{
					statement.close();
					statement=null;
				}
				if(conn!=null)
				{
					conn.close();
					conn=null;
				}
			}
		
			catch(Exception e)
			{
				
			}
		}
	}
	
}