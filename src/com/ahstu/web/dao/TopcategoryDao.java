/**
 * 
 */
package com.ahstu.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.Topcategory;

/**
 * @author wss
 *
 */
public class TopcategoryDao extends HibernateDaoSupport {

	/**
	 * @return
	 */
	public List<Topcategory> findAll() {
		// TODO Auto-generated method stub
		
		String hql="from Topcategory";
		List<Topcategory> list=this.getHibernateTemplate().find(hql);
		
		return list;
	}
//dao层保存一级分类的方法
	
	public void save(Topcategory topcategory) {
	this.getHibernateTemplate().save(topcategory);
	}

}
