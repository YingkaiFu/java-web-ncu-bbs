package com.ncu.strong.bbs.util;

import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUploadUtil {

    public FileUploadUtil(){}
   public static int uploadFile(MultipartFile file){
       if(file.isEmpty()){
           return 0;
       }
       try{
           byte [] bytes = file.getBytes();
           /*Date date = new Date();
           String str = "yyyy-MM-dd hh:mm:ss";
           SimpleDateFormat format = new SimpleDateFormat(str);
           String dateFormat = format.format(date) + " ";*/

           Path path = Paths.get("src/main/resources/static/images/" + file.getOriginalFilename());
           Files.write(path,bytes);
       }catch (IOException e){
           e.printStackTrace();
       }
       return 1;
   }
}