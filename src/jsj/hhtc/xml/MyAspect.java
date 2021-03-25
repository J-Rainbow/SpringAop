package jsj.hhtc.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	//前置通知
	public void myBefore(JoinPoint joinPoint){
		System.out.println("1.前置通知..." + joinPoint.getSignature().getName());
	}
	/**
	 * 后置通知获取service方法执行后的返回值
	 * Object retValue:service方法执行的返回值,如果写了返回值，需要在xml中配置returning
	 * @param
	 */
	public void myAfterReturning(JoinPoint joinPoint,Object retValue){
		System.out.println("3.后置通知..." +  joinPoint.getSignature().getName());
		System.out.println("返回值:" + retValue);
	}
	//环绕通知
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("2.环绕通知..开启事务.."+proceedingJoinPoint.getSignature().getName());
		Object retObj = proceedingJoinPoint.proceed();
		System.out.println("环绕通知提交事务...");
		return retObj;
	}
	//异常事件捕获
	public void myAfterThrowing(JoinPoint joinPoint,Throwable ex){
		System.out.println("异常通知..." + joinPoint.getSignature().getName() + "===" + ex.getMessage() );
	}
	//最终通知
	public void myAfter(JoinPoint jp){
		System.out.println("最终通知..." + jp.getSignature().getName());
	}
}
