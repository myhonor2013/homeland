package org.myhonor.tinystar.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myhonor.tinystar.entity.UserInfo;
import org.myhonor.tinystar.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "index.action", method = RequestMethod.GET)
	public String home() {
		return "login/login";
	}

	@RequestMapping(value = "/login/login.action", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request,
			@RequestParam String username, @RequestParam String password)
			throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setPassword(password);
		userInfo.setUsername(username);
		logger.info("User " + username + " log on!");
		boolean isValid = userService.loginCheck(userInfo);
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

}
