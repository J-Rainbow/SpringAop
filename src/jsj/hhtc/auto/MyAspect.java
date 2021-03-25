package jsj.hhtc.auto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	//声明一个公共的切入点
	@Pointcut("execution(* jsj.hhtc.auto.*.*(..))")
	public void myPointcut(){};

	//前置通知
	@Before("myPointcut()")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("1.前置通知..." + joinPoint.getSignature().getName());
	}
	/**
	 * 后置通知获取service方法执行后的返回值
	 * Object retValue:service方法执行的返回值,如果写了返回值，需要在xml中配置returning
	 * @param
	 */
	@AfterReturning(pointcut = "myPointcut()",returning = "retValue")
	public void myAfterReturning(JoinPoint joinPoint,Object retValue){
		System.out.println("3.后置通知..." +  joinPoint.getSignature().getName());
		System.out.println("返回值:" + retValue);
	}
	//环绕通知
	@Around("myPointcut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("2.环绕通知。。。开启事务。。"+proceedingJoinPoint.getSignature().getName());
		Object retObj = proceedingJoinPoint.proceed();
		System.out.println("环绕通知提交事务。。。");
		return retObj;
	}
	//异常事件捕获
	@AfterThrowing(pointcut = "myPointcut()",throwing = "ex")
	public void myAfterThrowing(JoinPoint jp,Throwable ex){
		System.out.println("异常通知..." + jp.getSignature().getName() + "===" + ex.getMessage() );
	}
	//最终通知
	@After("myPointcut()")
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知..." + joinPoint.getSignature().getName());
	}
}
