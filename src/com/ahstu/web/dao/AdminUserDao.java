package com.ahstu.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.AdminUser;
/**
 * 
 * @安科 王宿生
 *
 */
public class AdminUserDao extends HibernateDaoSupport{
  //dao中的登陆方法
	public AdminUser login(AdminUser adminUser) {
		String hql="from AdminUser where username = ? and password =?";
		
		List<AdminUser> list=this.getHibernateTemplate().find(hql,
				adminUser.getUsername(),adminUser.getPassword());
		
		if(list!=null &&list.size()>0){
			return list.get(0);
			
			
			
		}
		return null;
	}

}
