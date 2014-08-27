package com.linux.forum.login;

import org.apache.log4j.Logger;

import com.linux.forum.common.BaseAction;
import com.linux.forum.dao.DbHelper;
import com.linux.forum.entity.UserInfo;

public class Login extends BaseAction {
	private static final long serialVersionUID = 2133386332599719629L;
	static Logger logger = Logger.getLogger(Login.class.getName());
	private UserInfo userInfo;

	private LoginUtils loginService;

	private DbHelper dbHelper;

	public String doLogin() throws Exception {
		boolean isValid = dbHelper.authenUserInfo(userInfo.getUsername(),
				userInfo.getPassword());
		if (!isValid) {
			return ERROR;
		} else {
			return SUCCESS;
		}
		// EnumLoginResult result = this.loginService
		// .validate(username, password);
		// if (EnumLoginResult.SUCCESS == result)
		// {
		// request.getSession(true).setAttribute(
		// "username", username);
		// request.getSession(false)
		// .setMaxInactiveInterval(30);
		// request.setAttribute("test", "yes");
		// return SUCCESS;
		// }
		// else
		// {
		// return ERROR;
		// }
	}

	public LoginUtils getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginUtils loginService) {
		this.loginService = loginService;
	}

	public DbHelper getDbHelper() {
		return dbHelper;
	}

	public void setDbHelper(DbHelper dbHelper) {
		this.dbHelper = dbHelper;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
