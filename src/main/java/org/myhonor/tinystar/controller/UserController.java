package org.myhonor.tinystar.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myhonor.tinystar.entity.User;
import org.myhonor.tinystar.framework.Constants;
import org.myhonor.tinystar.service.INavService;
import org.myhonor.tinystar.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
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
    
    @Resource
    private INavService navService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(
            HttpServletRequest request,
            @RequestParam(value = "localeName", required = false) String localeName,
            Model model)
    {
        request.getSession().setAttribute(Constants.LOCALENAME,
                "en_US".equals(localeName) ? "en_US" : "zh_CN");
        User user = new User("aa", "aa");
        model.addAttribute("user", user);
        return "login/login";
    }
    
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request,
            HttpServletResponse response)
    {
        // request.getSession().invalidate();
        request.getSession().removeAttribute(Constants.COOKIENAME_USERNAME);
        Cookie cookie = new Cookie(Constants.COOKIENAME_USERNAME, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
    
    @RequestMapping(value = "register")
    public String register(HttpServletRequest request,
            HttpServletResponse response)
    {
        return "login/register";
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,
            HttpServletResponse response, @RequestBody User user)
            throws Exception
    {
        logger.info("User " + user.getUsername() + " log on!");
        boolean isValid = userService.countUser(user) > 0 ? true : false;
        if (isValid)
        {
            request.getSession().setAttribute(Constants.COOKIENAME_USERNAME,
                    user.getUsername());
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
                        user.getUsername());
                cookie.setHttpOnly(true);
                cookie.setMaxAge(60 * 15);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            // return new JsonResult(true, "success");
            
            return "success";
        }
        else
        {
            // return new JsonResult(true, "failed");
            return "failed";
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
    
    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public String home(@PathVariable String username, Map<String, Object> model)
    {
        model.put("navs", navService.selectAllNavs());
        model.put("cur", 1);
        return "home/home";
    }
}
