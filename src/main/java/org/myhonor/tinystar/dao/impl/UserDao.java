package org.myhonor.tinystar.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.myhonor.tinystar.dao.IUserDao;
import org.myhonor.tinystar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public boolean loginCheck(User user) {
		return (int) sessionTemplate
.selectOne(
				"org.myhonor.tinystar.dao.IUserDao.checkAccount", user) > 0 ? true
				: false;
	}
}
