package org.myhonor.tinystar.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.myhonor.tinystar.framework.Constants;
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
    
    @RequestMapping(value = "getPhoto", method = RequestMethod.GET)
    public void go(HttpServletResponse response,
            @RequestParam(value = "curPic", required = false) String curPic,
            @RequestParam(value = "direction", required = false) int direction,
            Map<String, Object> model) throws IOException
    {
        String name = getPic(curPic, direction);
        model.put("photo", "image/upload/" + name);
        response.getWriter().print("image/upload/" + name);
        return;
    }
    
    @RequestMapping(value = "photo", method = RequestMethod.GET)
    public String showPhotoHome(Map<String, Object> model)
    {
        model.put("photo", "image/upload/" + getPic(null, 0));
        model.put("navs", navService.selectAllNavs());
        model.put("cur", 2);
        return "photo/photo";
    }
    
    @RequestMapping(value = "photo", method = RequestMethod.POST)
    public String addPhoto(
            @RequestParam(value = "photo", required = true) MultipartFile photo,
            Map<String, Object> model)
    {
        String fileName = Constants.PIC_PATH
                + Long.toString(Thread.currentThread().getId()) + "_"
                + System.currentTimeMillis() + ".jpeg";
        if (!photo.isEmpty() && validatePhoto(photo))
        {
            savePhoto(photo, fileName);
        }
        model.put("photo", "image/upload/1.jpeg");
        model.put("navs", navService.selectAllNavs());
        model.put("cur", 2);
        return "photo/photo";
    }
    
    private boolean validatePhoto(MultipartFile photo)
    {
        return "image/jpeg".equals(photo.getContentType());
    }
    
    private void savePhoto(MultipartFile photo, String fileName)
    {
        File file = new File(fileName);
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
    
    public String getPic(String curName, int direction)
    {
        File path = new File(Constants.PIC_PATH);
        File[] files = path.listFiles();
        if (files != null && files.length > 0)
        {
            File file;
            int i = 0;
            for (; i < files.length; i++)
            {
                file = files[i];
                if (StringUtils.isBlank(curName))
                {
                    return file.getName();
                }
                if (curName.equals(file.getName()))
                {
                    break;
                }
            }
            return files[(i + direction + files.length) % files.length]
                    .getName();
        }
        return files[0].getName();
    }
}
