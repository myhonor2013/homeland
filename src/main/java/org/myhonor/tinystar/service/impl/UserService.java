package org.myhonor.tinystar.service.impl;

import javax.annotation.Resource;

import org.myhonor.tinystar.dao.IUserDao;
import org.myhonor.tinystar.entity.User;
import org.myhonor.tinystar.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
    
    @Resource
    private IUserDao userMapper;
    
    @Override
    public int getUser(User user)
    {
        return userMapper.countUser(user);
    }
    
}
