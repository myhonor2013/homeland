package org.myhonor.tinystar.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.myhonor.tinystar.dao.IUserDao;
import org.myhonor.tinystar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
    @Autowired
	private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
    
    @Override
    public int countUser(User user)
    {
        return (int) sqlSession
                .selectOne(
                        "org.myhonor.tinystar.dao.IUserDao.checkAccount", user);
    }
}
