package org.myhonor.tinystar.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseAction
{
	private static final long serialVersionUID = 8548573404471480155L;
	public HttpServletRequest request;
	public HttpServletResponse response;
	private static final Logger logger = LoggerFactory
			.getLogger(BaseAction.class);
}
