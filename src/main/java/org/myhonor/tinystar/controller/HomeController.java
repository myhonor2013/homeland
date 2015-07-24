package org.myhonor.tinystar.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.myhonor.tinystar.service.INavService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home/")
public class HomeController
{
    @Resource
    private INavService navService;
    
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Map<String, Object> model)
    {
        model.put("navs", navService.selectAllNavs());
        return "home/home";
    }
}
