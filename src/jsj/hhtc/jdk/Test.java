package jsj.hhtc.jdk;

/*
 * jdk¥˙¿Ì≤‚ ‘
 */
public class Test {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		UserDao userDaoProxy = new JdkProxy(userDao).getProxy();
		userDaoProxy.delete();
		userDaoProxy.save();
	}
}
