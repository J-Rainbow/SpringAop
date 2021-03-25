package jsj.hhtc.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	public Object createProxy(Object object){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("执行前的操作....");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("执行后的操作....");
		return null;
	}
}
