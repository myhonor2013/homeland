package org.myhonor.tinystar.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet Filter implementation class SessionListener
 */
public class GenericFilter implements Filter
{
    
    /**
     * Default constructor.
     */
    public GenericFilter()
    {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
    }
    
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        if (!(request instanceof HttpServletRequest)
                || !(response instanceof HttpServletResponse))
        {
            throw new ServletException(
                    GenericFilter.class.getCanonicalName()
                            + " just supports HTTP requests");
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        Cookie[] cookies = httpRequest.getCookies();
        if (null != cookies)
        {
            boolean isLocaleCookieExist = false;
            boolean isUserLogged = false;
            for (Cookie cookie : cookies)
            {
                if (Constants.COOKIENAME_LOCALE.equals(cookie.getName()))
                {
                    isLocaleCookieExist = true;
                    httpRequest.getSession().setAttribute(
                            Constants.COOKIENAME_LOCALE, cookie.getValue());
                }
                if (Constants.COOKIENAME_USERNAME.equals(cookie.getName()))
                {
                    if (!StringUtils.isEmpty(cookie.getValue()))
                    {
                        isUserLogged = true;
                    }
                }
            }
            
            if (!isLocaleCookieExist)
            {
                Cookie cookie = new Cookie(Constants.COOKIENAME_LOCALE,
                        Constants.COOKIEVALUE_DEFAULT_LOCALE);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(60 * 60 * 24 * 365);
                httpResponse.addCookie(cookie);
            }
            
            if (!isUserLogged
                    && !"/homeland/login/login.action"
                            .equals(httpRequest.getRequestURI())
                    && !"/homeland/index.action"
                            .equals(httpRequest.getRequestURI()))
            {
                httpResponse.sendRedirect("index.action");
                return;
                // request.getRequestDispatcher("/index.action").forward(
                // httpRequest, httpResponse);
            }
        }
        
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
    
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException
    {
        // TODO Auto-generated method stub
    }
    
}
