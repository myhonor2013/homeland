package org.myhonor.tinystar.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.myhonor.tinystar.service.INavService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/photo/")
public class PhotoController
{
    @Resource
    private INavService navService;
    
    @RequestMapping(value = "photo")
    public String showPhotoHome(Map<String, Object> model)
    {
        model.put("navs", navService.selectAllNavs());
        model.put("cur", 2);
        return "photo/photo";
    }
}
