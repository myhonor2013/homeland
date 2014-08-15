package com.linux.forum.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport
        implements ServletRequestAware,
        ServletResponseAware
{
	private static final long serialVersionUID = 8548573404471480155L;
	public HttpServletRequest request;
	public HttpServletResponse response;
	static Logger logger = Logger
	        .getLogger(BaseAction.class.getName());
	
	@Override
	public void setServletResponse(
	        HttpServletResponse response)
	{
		this.response = response;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}
	
}
