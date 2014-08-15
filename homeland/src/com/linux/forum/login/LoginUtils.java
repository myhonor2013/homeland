package com.linux.forum.login;

import org.apache.commons.lang3.StringUtils;

public class LoginUtils
{
	public EnumLoginResult validate(String username,
	        String password) throws Exception
	{
		if (StringUtils.isEmpty(username))
		{
			return EnumLoginResult.EMPTY_USERNAME;
		}
		if (StringUtils.isEmpty(password))
		{
			return EnumLoginResult.EMPTY_PASSWORD;
		}
		if (!username.equals("myhonor")
		        || !password.equals("myhonor"))
		{
			return EnumLoginResult.WRONG_USERNAME_OR_PASSWORD;
		}
		return EnumLoginResult.SUCCESS;
	}
	
}
