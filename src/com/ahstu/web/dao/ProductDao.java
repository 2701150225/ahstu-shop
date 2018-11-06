/**
 * 
 */
package com.ahstu.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.Product;
import com.ahstu.web.utils.PageHibernateCallback;



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
				criteria.addOrder(Order.desc("pdate"));// 按日期进行倒序排序:			
				List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 20);// 执行查询:
				return list;
	}

	
	//根据商品id查询商品
		public Product findPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid); 
	}
		//根据Id查询商品的个数
		public int findCountCid(Integer cid) {
			String hql = "select count(*) from Product p where p.categorySecond.topcategory.cid = ?";
			List<Long> list = this.getHibernateTemplate().find(hql,cid);
			if(list != null && list.size() > 0){
				return list.get(0).intValue();
			}
			return 0;
		}
		
	//根据一级分类的id查询商品的集合
	public List<Product> findPageCid(Integer cid, int begin, int limit) {
		// select p.* from category c,categorysecond cs,product p where c.cid = cs.cid and cs.csid = p.csid and c.cid = 2
		// select p from Category c,CategorySecond cs,Product p where c.cid = cs.category.cid and cs.csid = p.categorySecond.csid and c.cid = ?
		String hql = "select p from Product p join p.categorySecond cs join cs.topcategory c where c.cid = ?";
		// 分页另一种写法:
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
		
	}

	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	
	
	public List<Product> findPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
	
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	



	


}
