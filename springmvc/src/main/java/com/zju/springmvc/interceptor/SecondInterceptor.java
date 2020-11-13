//package com.zju.myspring.SpringMVC.Interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author 况祥彬
// * @date 2020/11/3 20:58
// **/
//public class SecondInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//        // TODO Auto-generated method stub
//        System.out.println("preHandle...");
//      //todo 不放行
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // TODO Auto-generated method stub
//        System.out.println("...postHandle...");
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request,
//                                HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // TODO Auto-generated method stub
//        System.out.println("...afterCompletion...");
//    }
//
//}
