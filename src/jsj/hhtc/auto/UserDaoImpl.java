package jsj.hhtc.auto;

import org.springframework.stereotype.Repository;

import javax.annotation.Resources;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	public void delete() {
		System.out.println("ɾ������");
	}

	public void save() {
		System.out.println("��������");
	}

}
