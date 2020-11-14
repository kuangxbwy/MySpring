package AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 况祥彬
 * @date 2020/11/8 21:53
 **/
//@Aspect
@Component
public class ValidateAspact {

//    @Pointcut("execution(* AOP..*(..))")
    @Pointcut("execution(* *..*(..))")
    public void pc(){};
    @Before("pc()")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行是使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("111【"+name+"】方法开始执行，用的参数列表【"+ Arrays.asList(args)+"】");
    }

    @AfterReturning(value = "pc()",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("111【"+name+"】方法正常执行完成，计算结果是："+result);
    }

    @AfterThrowing(value="execution(* *..*(..))",throwing="exception")
    public static void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println("111【"+joinPoint.getSignature().getName()+"】方法执行出现异常了，异常信息是【"+exception+"】：；这个异常已经通知测试小组进行排查");
    }

    @After("execution(* *..*(..))")
    private int logEnd(JoinPoint joinPoint) {
        System.out.println("111【"+joinPoint.getSignature().getName()+"】方法最终结束了");
        return 0;
    }
}
