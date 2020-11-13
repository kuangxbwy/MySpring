package com.zju.spring.spring.AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 * @author lfy
 *
 */
@Aspect
@Component
@Order(0)
public class LogUtils {
//	@Pointcut("execution(* com.zju.spring.spring.AOP.aop.*(..))")
//	public void pc(){};

	@Before("execution(* *..*(..))")
	public static void logStart(JoinPoint joinPoint){
		//获取到目标方法运行是使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法开始执行，用的参数列表【"+Arrays.asList(args)+"】");
	}
	
	/**
	 * 记住两种；
	 * 最精确的：execution(public int com.atguigu.impl.MyMathCalculator.add(int,int))
	 * 最模糊的：execution(* *.*(..))：千万别写；
	 * 
	 * &&”、“||”、“!
	 * 
	 * &&：我们要切入的位置满足这两个表达式
	 * 	MyMathCalculator.add(int,double)
	 * execution(public int com.atguigu..MyMath*.*(..))&&execution(* *.*(int,int))
	 * 
	 * 
	 * ||:满足任意一个表达式即可
	 * execution(public int com.atguigu..MyMath*.*(..))&&execution(* *.*(int,int))
	 * 
	 * !：只要不是这个位置都切入
	 * !execution(public int com.atguigu..MyMath*.*(..))
	 * 
	 * 告诉Spring这个result用来接收返回值：
	 * 	returning="result"；
	 */
	//想在目标方法正常执行完成之后执行
	@AfterReturning(value="execution(* *..*(..))",returning="result")
	public static void logReturn(JoinPoint joinPoint,Object result){
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法正常执行完成，计算结果是："+result);
	}

	
	/**
	 * 细节四：我们可以在通知方法运行的时候，拿到目标方法的详细信息；
	 * 1）只需要为通知方法的参数列表上写一个参数：
	 * 		JoinPoint joinPoint：封装了当前目标方法的详细信息
	 * 2）、告诉Spring哪个参数是用来接收异常
	 * 		throwing="exception"：告诉Spring哪个参数是用来接收异常
	 * 3）、Exception exception:指定通知方法可以接收哪些异常
	 *
	 */
	//想在目标方法出现异常的时候执行
	@AfterThrowing(value="execution(* *..*(..))",throwing="exception")
	public static void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行出现异常了，异常信息是【"+exception+"】：；这个异常已经通知测试小组进行排查");
	}

	//想在目标方法结束的时候执行
	/**
	 * Spring对通知方法的要求不严格；
	 * 唯一要求的就是方法的参数列表一定不能乱写？
	 * 	通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值；
	 * 	参数表上的每一个参数，Spring都得知道是什么？
	 * 	JoinPoint:认识
	 * 	不知道的参数一定告诉Spring这是什么？
	 * 
	 * @param joinPoint
	 */
	@After("execution(* *..*(..))")
	private int logEnd(JoinPoint joinPoint) {
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法最终结束了");
		return 0;
	}

	@Around("execution(* *..*(..))")
	private void logAround(ProceedingJoinPoint pjp){

		Object[] args = pjp.getArgs();
		Object proceed=null;
		String name = pjp.getSignature().getName();
		try {
			System.out.println("环绕前置 "+name);
			//利用反射调用目标方法，proceed即为方法返回值
			proceed = pjp.proceed(args);
			System.out.println("环绕返回通知 "+proceed);
		} catch (Throwable e) {
			System.out.println("环绕异常通知"+e);
			//为了让外界知道这个异常 一定要抛出去
			throw  new RuntimeException(e);
		}finally {
			System.out.println("环绕最终通知"+name);
		}

	}


}
