package org.myhonor.homeland.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.myhonor.homeland.dao.IUserInfoDao;
import org.myhonor.homeland.entity.UserInfo;

public class UserInfoDao extends SqlSessionDaoSupport   implements IUserInfoDao{

	@Override
	public boolean loginCheck(UserInfo userInfo) {
		return getSqlSession().selectOne("org.myhonor.count");
	}
}
