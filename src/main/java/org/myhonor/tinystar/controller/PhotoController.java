package org.myhonor.tinystar.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.myhonor.tinystar.service.INavService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/photo/")
public class PhotoController
{
    @Resource
    private INavService navService;
    
    @RequestMapping(value = "photo", method = RequestMethod.GET)
    public String showPhotoHome(Map<String, Object> model)
    {
        model.put("navs", navService.selectAllNavs());
        model.put("cur", 2);
        return "photo/photo";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPhoto(
            @RequestParam(value = "photo", required = true) MultipartFile photo,
            Map<String, Object> model)
    {
        if (!photo.isEmpty() && validatePhoto(photo))
        {
            savePhoto(photo);
        }
        return "photo/photo";
    }
    
    private boolean validatePhoto(MultipartFile photo)
    {
        return "image/jpeg".equals(photo.getContentType());
    }
    
    private void savePhoto(MultipartFile photo)
    {
        File file = new File("D:\\code\\static_file\\1.jpeg");
        try
        {
            FileUtils.writeByteArrayToFile(file, photo.getBytes());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
