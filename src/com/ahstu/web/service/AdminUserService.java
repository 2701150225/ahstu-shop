package com.ahstu.web.service;

import com.ahstu.web.dao.AdminUserDao;
import com.ahstu.web.pojo.AdminUser;

/**
 * 后台登录业务层代码
 * @安科 王宿生
 *
 */
public class AdminUserService {
   
	//注入Dao
	private   AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
    //登录
	public AdminUser login(AdminUser adminUser) {
	
		return adminUserDao.login(adminUser);
	}
	
}
