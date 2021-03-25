package jsj.hhtc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler{
	private Object target;

	public JdkProxy(Object target) {
		super();
		this.target = target;
	}
	
	/**
	 * ��ȡ������ӿ�ʵ������
	 */
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("���ڼ�¼IP...");
		Object result = method.invoke(target, args);
		System.out.println("���ڼ�¼��Ϊ...");
		return result;
	}

	
}
