package org.myhonor.homeland.login;

import org.myhonor.homeland.common.BaseAction;
import org.myhonor.homeland.dao.IUserInfoDao;
import org.myhonor.homeland.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login extends BaseAction {
	private static final long serialVersionUID = 2133386332599719629L;
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	private UserInfo userInfo;
private String username;
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

private String password;
	private LoginUtils loginService;

	private IUserInfoDao userInfoDao;

	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public String doLogin() throws Exception {
		userInfo=new UserInfo();
		userInfo.setPassword(password);
		userInfo.setUsername(username);
		logger.info("User " + username + " log on!");
		boolean isValid = userInfoDao.loginCheck(userInfo);
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


	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
