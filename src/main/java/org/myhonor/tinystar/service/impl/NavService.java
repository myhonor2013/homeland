package org.myhonor.tinystar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.myhonor.tinystar.dao.INavDao;
import org.myhonor.tinystar.entity.Nav;
import org.myhonor.tinystar.service.INavService;
import org.springframework.stereotype.Service;

@Service
public class NavService implements INavService
{
    @Resource
    private INavDao navDao;
    
    @Override
    public List<Nav> selectAllNavs()
    {
        return navDao.selectAllNavs();
    }
    
}
