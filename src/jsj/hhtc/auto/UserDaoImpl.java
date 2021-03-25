package jsj.hhtc.auto;

import org.springframework.stereotype.Repository;

import javax.annotation.Resources;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	public void delete() {
		System.out.println("删除数据");
	}

	public void save() {
		System.out.println("保存数据");
	}

}
