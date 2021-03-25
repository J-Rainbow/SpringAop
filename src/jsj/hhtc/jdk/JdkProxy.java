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
	 * 获取被代理接口实例对象
	 */
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("正在记录IP...");
		Object result = method.invoke(target, args);
		System.out.println("正在记录行为...");
		return result;
	}

	
}
