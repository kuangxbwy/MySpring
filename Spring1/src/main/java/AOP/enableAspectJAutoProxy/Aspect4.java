package AOP.enableAspectJAutoProxy;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspect4 {
    @Pointcut("execution(* AOP.enableAspectJAutoProxy.Service4.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before() {
        System.out.println("@Before通知!");
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around通知start");
        Object result = joinPoint.proceed();
        System.out.println("@Around绕通知end");
        return result;
    }

    @After("pc()")
    public void after() throws Throwable {
        System.out.println("@After通知!");
    }

    @AfterReturning(value ="pc()",returning="result")
    public void afterReturning(Joinpoint joinpoint, Object result) throws Throwable {
        System.out.println("@AfterReturning通知!");
    }

    @AfterThrowing(value = "pc()",throwing = "exception")
    public void afterThrowing(Exception exception) {
        System.out.println("@AfterThrowing通知!");
    }

}
