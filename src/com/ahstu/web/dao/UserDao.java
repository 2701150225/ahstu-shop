package com.ahstu.web.dao;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ahstu.web.pojo.User;
/**
 * 
 * @author wss
 * 用户模块持久层代码
 */
public class UserDao extends HibernateDaoSupport{

	// 使用hibernate操作数据库进行查询:
	public User findUsername(String username){
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}         

	// 把注册用户保存到数据库save方法
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	// 通过激活码查询用户是否存在
	public User findCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql,code);
		if(list != null && list.size() > 0){
		return list.get(0);
		}
		return null;
	}
	
	
	
	
	// 更新用户注册状态
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}



	// 用户登录
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword(),1);
		if(list != null && list.size() > 0){
		return list.get(0);
		}
		return null;
	}
}