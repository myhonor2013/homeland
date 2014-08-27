package com.linux.forum.dao;

import com.linux.forum.entity.UserInfo;

public class UserInfoDao {

	private static UserInfoDao instance;

	private UserInfoDao() {
	}

	public static UserInfoDao getInstace() {
		if (instance == null) {
			instance = new UserInfoDao();
		}
		return instance;
	}

	public boolean isUserInfoOK(UserInfo userInfo) {
		return false;
	}
}
