package org.myhonor.tinystar.dao;

import org.myhonor.tinystar.entity.UserInfo;

public interface IUserDao {
	public boolean loginCheck(UserInfo userInfo);
}
