/**
 * 
 */
package com.ahstu.web.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.Product;



/**
 * 二手商品的持久层代码
 * @安科 王宿生
 *
 */
public class ProductDao extends HibernateDaoSupport {

	

	public List<Product> findHot() {
		//使用离线条件查询，从web曾获取数据封装到criteria
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 查询热门的商品,条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		// 倒序排序输出:
		criteria.addOrder(Order.desc("pdate"));
		// 执行查询:
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 20);
		return list;
	}

	public List<Product> findNew() {
		// 使用离线条件查询:
				DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
				// 按日期进行倒序排序:
				criteria.addOrder(Order.desc("pdate"));
				// 执行查询:
				List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 20);
				return list;
	}

	
	
	public Product findPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid); //根据商品id查询商品
	}


}
