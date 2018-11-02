package com.ahstu.web.service;

import org.springframework.transaction.annotation.Transactional;
import com.ahstu.web.dao.UserDao;
import com.ahstu.web.pojo.User;
import com.ahstu.web.utils.MailUitls;
import com.ahstu.web.utils.UUIDUtils;

/**
 * 用户名模块业务逻辑层代码
 * 
 * @author wss
 *
 */
@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 按用户名查询用户的方法:
	public User findUsername(String username) {
		return userDao.findUsername(username);
	}


	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活. 1:代表用户已经激活.
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		MailUitls.sendMail(user.getEmail(), code);//发送激活邮件

		
	}

	// 业务层根据激活码查询用户
	public User findCode(String code) {
		return userDao.findCode(code);
	}

	// 修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}
}
