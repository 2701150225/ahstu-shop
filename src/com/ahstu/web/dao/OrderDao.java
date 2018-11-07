package com.ahstu.web.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.Order;

/**
 * 
 * @安科 王宿生
 *
 */
public class OrderDao extends HibernateDaoSupport {

	public void save(Order order) {
		this.getHibernateTemplate().save(order);		
	}

	
}
