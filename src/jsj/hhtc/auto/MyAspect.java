package jsj.hhtc.auto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	//����һ�������������
	@Pointcut("execution(* jsj.hhtc.auto.*.*(..))")
	public void myPointcut(){};

	//ǰ��֪ͨ
	@Before("myPointcut()")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("1.ǰ��֪ͨ..." + joinPoint.getSignature().getName());
	}
	/**
	 * ����֪ͨ��ȡservice����ִ�к�ķ���ֵ
	 * Object retValue:service����ִ�еķ���ֵ,���д�˷���ֵ����Ҫ��xml������returning
	 * @param
	 */
	@AfterReturning(pointcut = "myPointcut()",returning = "retValue")
	public void myAfterReturning(JoinPoint joinPoint,Object retValue){
		System.out.println("3.����֪ͨ..." +  joinPoint.getSignature().getName());
		System.out.println("����ֵ:" + retValue);
	}
	//����֪ͨ
	@Around("myPointcut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("2.����֪ͨ�������������񡣡�"+proceedingJoinPoint.getSignature().getName());
		Object retObj = proceedingJoinPoint.proceed();
		System.out.println("����֪ͨ�ύ���񡣡���");
		return retObj;
	}
	//�쳣�¼�����
	@AfterThrowing(pointcut = "myPointcut()",throwing = "ex")
	public void myAfterThrowing(JoinPoint jp,Throwable ex){
		System.out.println("�쳣֪ͨ..." + jp.getSignature().getName() + "===" + ex.getMessage() );
	}
	//����֪ͨ
	@After("myPointcut()")
	public void myAfter(JoinPoint joinPoint){
		System.out.println("����֪ͨ..." + joinPoint.getSignature().getName());
	}
}
