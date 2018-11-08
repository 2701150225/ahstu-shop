package com.ahstu.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.Order;
import com.ahstu.web.utils.PageHibernateCallback;
/**
 * 
 * @安科 王宿生
 *
 */
public class OrderDao extends HibernateDaoSupport {
     
	public void save(Order order) {
		this.getHibernateTemplate().save(order);		
	}
    //用户订单个数的统计
	public Integer findCountUid(Integer uid) {
		String hql="select  count(*) from Order o where o.user.uid = ?";
		List<Long>list=this.getHibernateTemplate().find(hql, uid);
		if(list !=null && list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Order> findPageUid(Integer uid, Integer begin, Integer limit) {
	String hql="from Order o where o.user.uid = ? order by ordertime desc order";
    List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,new Object[] {uid},begin,limit));
		return list;
	}

	
	
}
