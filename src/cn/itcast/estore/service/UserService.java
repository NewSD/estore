package cn.itcast.estore.service;

import cn.itcast.estore.dao.UserDao;
import cn.itcast.estore.domain.User;
import cn.itcast.estore.utils.MailUtils;
import cn.itcast.estore.utils.UUIDUtils;

//用户业务类
public class UserService {

	//注册用户
	public void regist(User user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		user.setUid(UUIDUtils.getUUID());
		user.setState(0);//未激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();//激活码
		user.setCode(code);
		userDao.save(user);
		//发邮件
		MailUtils.sendMail(user.getEmail(), code);
	}

	//查询用户名是否存在
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.findByUsername(username);
		
	}
	//查询激活码的用户
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.findByCode(code);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		userDao.update(user);
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		return userDao.login(user);
	}

}
