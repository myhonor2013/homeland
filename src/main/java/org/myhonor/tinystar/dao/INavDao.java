package org.myhonor.tinystar.dao;

import java.util.List;

import org.myhonor.tinystar.entity.Nav;

public interface INavDao
{
    public List<Nav> selectAllNavs();
}
