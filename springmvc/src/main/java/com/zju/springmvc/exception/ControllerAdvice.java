//package com.zju.myspring.SpringMVC.Exception;
//
//
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * @author 况祥彬
// * @date 2020/11/3 21:11
// *一个类还好，一百个类呢？每个类里面都像ExceptionTestController那样在类里面定义处理异常的方法吗？
// *
// * 定义一个集中处理所有异常的类，所有类发生异常都到本类来处理
// * 需要将此类加入到ioc容器中,通过@ControllerAdvice来做到，@ControllerAdvice：专门处理异常的类
// **/
//@org.springframework.web.bind.annotation.ControllerAdvice
//public class ControllerAdvice {
//
//    @ExceptionHandler(value = {NullPointerException.class})
//    public ModelAndView testJiZhongExceptionHandler(Exception exception){
//        System.out.println("本类的：handleException01..." + exception);
//        ModelAndView view = new ModelAndView("myerror");
//        view.addObject("ex", exception);
//        // 视图解析器拼串
//        return view;
//    }
//}
