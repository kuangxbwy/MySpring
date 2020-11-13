//package com.zju.myspring.SpringMVC.Exception;
//
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * @author 况祥彬
// * @date 2020/11/3 20:59
// * 一个普通类，里面定义异常处理方法
// **/
//@RestController
//public class ExceptionTestController {
//    /**
//     * 告诉SpringMVC这个方法专门处理本类发生的异常
//     * 1、给方法上随便写一个Exception，用来接受发生的异常
//     * 2、因为不是目标方法，并且要携带异常信息，索引不能给参数位置写Model；
//     * 3、返回ModelAndView就行了；
//     * 4、如果有多个@ExceptionHandler都能处理这个异常，精确优先,     即：当发生空指针异常时，优先找testExceptionHandler01处理，而不是testExceptionHandler02
//     * 5、全局异常处理与本类同时存在，本类优先；即：当发生空指针异常时，优先找Handler01处理，而不是JiZhongException中的testJiZhongExceptionHandler
//     */
//    @ExceptionHandler(value = {NullPointerException.class})
//    public ModelAndView testExceptionHandler01(Exception exception){
//        System.out.println("本类的：handleException01..." + exception);
//		ModelAndView view = new ModelAndView("myerror");
//		view.addObject("ex", exception);
//		// 视图解析器拼串
//		return view;
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    public ModelAndView testExceptionHandler02(Exception exception){
//        System.out.println("本类的：handleException01..." + exception);
//        ModelAndView view = new ModelAndView("myerror");
//        view.addObject("ex", exception);
//        // 视图解析器拼串
//        return view;
//    }
//}
