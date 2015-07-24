package org.myhonor.tinystar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error/")
public class ErrorController
{
    @RequestMapping(value = "error404")
    public String error404()
    {
        return "error/404";
    }
    
    @RequestMapping(value = "error500")
    public String error500()
    {
        return "error/500";
    }
}
