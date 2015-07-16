package org.myhonor.tinystar.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myhonor.tinystar.entity.User;
import org.myhonor.tinystar.framework.Constants;
import org.myhonor.tinystar.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController
{
    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);
    
    private User userinfo;
    
    public User getUserinfo()
    {
        return userinfo;
    }
    
    public void setUserinfo(User userinfo)
    {
        this.userinfo = userinfo;
    }
    
    @Resource
    private IUserService userService;
    
    @RequestMapping(
            value = "index.action")
    public String home(HttpServletRequest request,
            HttpServletResponse response)
    {
        return "login/login";
    }
    
    @RequestMapping(
            value = "/login/login.action",
            method = RequestMethod.POST)
    public void doLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam String username, @RequestParam String password)
            throws Exception
    {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        logger.info("User " + username + " log on!");
        boolean isValid = userService.getUser(user) > 0 ? true : false;
        if (isValid)
        {
            request.getSession().setAttribute(Constants.COOKIENAME_USERNAME,
                    username);
            Cookie[] cookies = request.getCookies();
            boolean isUsernameCookieExist = false;
            for (Cookie cookie : cookies)
            {
                if (Constants.COOKIENAME_USERNAME.equals(cookie.getName()))
                {
                    isUsernameCookieExist = true;
                }
                
            }
            if (isUsernameCookieExist)
            {
                // request.getCookies()
            }
            else
            {
                Cookie cookie = new Cookie(Constants.COOKIENAME_USERNAME,
                        username);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(30);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            response.getWriter().print("success");
            
        }
        else
        {
            response.getWriter().print("error");
        }
        response.getWriter().flush();
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
