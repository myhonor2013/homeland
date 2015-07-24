package org.myhonor.tinystar.entity;


public class Nav
{
    private String name;
    private String url;
    private int orderno;
    
    public int getOrderno()
    {
        return orderno;
    }
    
    public void setOrderno(int orderno)
    {
        this.orderno = orderno;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
}
