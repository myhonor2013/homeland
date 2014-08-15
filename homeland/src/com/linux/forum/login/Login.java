package com.linux.forum.login;

import org.apache.log4j.Logger;

import com.linux.forum.common.BaseAction;
import com.linux.forum.dao.DbHelper;

public class Login extends BaseAction
{
	private static final long serialVersionUID = 2133386332599719629L;
	static Logger logger = Logger.getLogger(Login.class
	        .getName());
	private String username;
	
	private String password;
	
	private LoginUtils loginService;
	
	private DbHelper dbHelper;
	
	

	public String doLogin() throws Exception
	{
		boolean isValid=dbHelper.authenUserInfo(username,password);
		if(!isValid)
		{
			return ERROR;
		}
		EnumLoginResult result = this.loginService
		        .validate(username, password);
		if (EnumLoginResult.SUCCESS == result)
		{
			request.getSession(true).setAttribute(
			        "username", username);
			request.getSession(false)
			        .setMaxInactiveInterval(30);
			request.setAttribute("test", "yes");
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public LoginUtils getLoginService()
	{
		return loginService;
	}
	
	public void setLoginService(LoginUtils loginService)
	{
		this.loginService = loginService;
	}
	public DbHelper getDbHelper()
	{
		return dbHelper;
	}

	public void setDbHelper(DbHelper dbHelper)
	{
		this.dbHelper = dbHelper;
	}
}
