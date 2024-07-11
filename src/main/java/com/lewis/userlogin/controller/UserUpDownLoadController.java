package com.lewis.userlogin.controller;

import com.lewis.userlogin.entity.UserUpDownLoad;
import com.lewis.userlogin.repository.UserUpDownLoadRepository;
import com.lewis.userlogin.service.UserUpDownLoadService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserUpDownLoadController {

    @Autowired
    private UserUpDownLoadService userUpDownLoadService;

   //handler metod for main index page,
    @GetMapping("/updownindex")
    public String home(Model model){
        List<UserUpDownLoad> list = userUpDownLoadService.getAllUserUpDownLoads();
        model.addAttribute("list", list);
        return "updown-index";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile file,  Model model) throws IOException{
        UserUpDownLoad userUpDownLoad = new UserUpDownLoad();
        String fileName = file.getOriginalFilename();
        userUpDownLoad.setUserProfilePic(fileName);
        userUpDownLoad.setContent(file.getBytes());
        userUpDownLoad.setSize(file.getSize());
        userUpDownLoadService.createUser(userUpDownLoad);
        model.addAttribute("success", "File Uploaded Successfully!!!");
        return "updown-index";

    }
    @GetMapping("/downloadfile")
    public void downloadFile(@Param("id")Long id, Model model, HttpServletResponse response) throws IOException{
        Optional<UserUpDownLoad> temp = userUpDownLoadService.getUserUpDownLoadById(id);
        if(temp!=null){
            UserUpDownLoad userUpDownLoad = temp.get();
            response.setContentType("application/octet-stream"); //indicates that the body contains arbitrary binary data
            String headerKey = "Content-Disposition";  //sets content to be displayed inline in browser
            String headerValue = "attachment; filename = " + userUpDownLoad.getUserProfilePic();
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream= response.getOutputStream();
            outputStream.write(userUpDownLoad.getContent());
            outputStream.close();
        }
    }

    @GetMapping("/image")
    public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<UserUpDownLoad> userUpDownLoad) throws ServletException, IOException{
        userUpDownLoad = userUpDownLoadService.getUserUpDownLoadById(id);
        response.setContentType(("application/octet-stream"));  //Default content type

        response.getOutputStream().write(userUpDownLoad.get().getContent());
        response.getOutputStream().close();

    }
}
