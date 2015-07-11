package org.myhonor.tinystar.dao;

import org.myhonor.tinystar.entity.User;

public interface IUserDao {
	public boolean loginCheck(User userInfo);
}
