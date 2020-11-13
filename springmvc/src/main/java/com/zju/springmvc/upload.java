//package com.zju.myspring.SpringMVC;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * @author 况祥彬
// * @date 2020/11/3 18:35
// **/
//@RestController
//public class upload {
//
//    @RequestMapping("/upload")
//    public String testUpLoad(@RequestParam("file") MultipartFile file) throws IOException {
//        System.out.println(file.getName());
//        if(!file.isEmpty()){
//            file.transferTo(new File("C:/kk"+file.getOriginalFilename()));
//            return "redirect:success";
//        }else {
//            return "redirect:fail";
//        }
//    }
//
//    //多文件上传
//
//    @RequestMapping("/upload2")
//    public String testUpLoad2(@RequestParam("file") MultipartFile [] multipartFiles) throws IOException {
//        for (MultipartFile file : multipartFiles) {
//            System.out.println(file.getName());
//            if(!file.isEmpty()){
//                file.transferTo(new File("C:/kk"+file.getOriginalFilename()));
//                return "redirect:success";
//            }else {
//                return "redirect:fail";
//            }
//        }
//        return  "ok";
//    }
//
//
//}
