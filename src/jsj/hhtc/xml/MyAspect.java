package jsj.hhtc.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	//ǰ��֪ͨ
	public void myBefore(JoinPoint joinPoint){
		System.out.println("1.ǰ��֪ͨ..." + joinPoint.getSignature().getName());
	}
	/**
	 * ����֪ͨ��ȡservice����ִ�к�ķ���ֵ
	 * Object retValue:service����ִ�еķ���ֵ,���д�˷���ֵ����Ҫ��xml������returning
	 * @param
	 */
	public void myAfterReturning(JoinPoint joinPoint,Object retValue){
		System.out.println("3.����֪ͨ..." +  joinPoint.getSignature().getName());
		System.out.println("����ֵ:" + retValue);
	}
	//����֪ͨ
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("2.����֪ͨ..��������.."+proceedingJoinPoint.getSignature().getName());
		Object retObj = proceedingJoinPoint.proceed();
		System.out.println("����֪ͨ�ύ����...");
		return retObj;
	}
	//�쳣�¼�����
	public void myAfterThrowing(JoinPoint joinPoint,Throwable ex){
		System.out.println("�쳣֪ͨ..." + joinPoint.getSignature().getName() + "===" + ex.getMessage() );
	}
	//����֪ͨ
	public void myAfter(JoinPoint jp){
		System.out.println("����֪ͨ..." + jp.getSignature().getName());
	}
}
