package jsj.hhtc.cglib;
/*
 * CGLIB´úÀí
 */
public class Test {
	public static void main(String[] args) {
		User user  = new User();
		CglibProxy cglibProxy = new CglibProxy();
		User user2 = (User) cglibProxy.createProxy(user);
		user2.say();
		System.out.println("..................");
		user2.run();
	}
}
