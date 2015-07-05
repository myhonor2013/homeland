package org.myhonor.homeland.dao;

import org.myhonor.homeland.entity.UserInfo;

public interface IUserInfoDao {
	public boolean loginCheck(UserInfo userInfo);
}
