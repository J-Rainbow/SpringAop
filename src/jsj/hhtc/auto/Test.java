package jsj.hhtc.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("jsj/hhtc/auto/bean.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		userDao.delete();
	}
}
