package org.myhonor.homeland.login;

import javax.servlet.http.HttpServletRequest;

import org.myhonor.homeland.dao.IUserInfoDao;
import org.myhonor.homeland.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	private LoginUtils loginService;

	private IUserInfoDao userInfoDao;

	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@RequestMapping(value = "/index.action", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/login/login.action", method = RequestMethod.GET)
	public String doLogin(HttpServletRequest request,
			@RequestParam String username, @RequestParam String password)
			throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setPassword(password);
		userInfo.setUsername(username);
		logger.info("User " + username + " log on!");
		boolean isValid = userInfoDao.loginCheck(userInfo);
		if (!isValid) {
			return "";
		} else {
			return "";
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
}
