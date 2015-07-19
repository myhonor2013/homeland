package org.myhonor.tinystar.controller;

import java.io.IOException;

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
@RequestMapping(
        value = "/")
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
            value = "")
    public String index(HttpServletRequest request,
            HttpServletResponse response, @RequestParam(
                    value = Constants.LOCALENAME,
                    required = false,
                    defaultValue = "defaultValue") String key)
    {
        String localeName = (String) request.getSession().getAttribute(
                Constants.LOCALENAME);
        request.getSession().setAttribute(Constants.LOCALENAME,
                "zh_CN".equals(localeName) ? "en_US" : "zh_CN");
        return "login/login";
    }
    
    @RequestMapping(
            value = "logout")
    public void logout(HttpServletRequest request,
            HttpServletResponse response)
    {
        // request.getSession().invalidate();
        request.getSession().removeAttribute(Constants.COOKIENAME_USERNAME);
        Cookie cookie = new Cookie(Constants.COOKIENAME_USERNAME, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        try
        {
            response.sendRedirect(request.getContextPath());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @RequestMapping(
            value = "login/login",
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
                cookie.setMaxAge(60 * 15);
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
