package com.ahstu.web.dao;

import java.util.List;

import org.omg.PortableInterceptor.NON_EXISTENT;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ahstu.web.pojo.CategorySecond;
import com.ahstu.web.utils.PageHibernateCallback;


/**
 * 
 * @安科 王宿生
 *
 */
public class CategorySecondDao extends HibernateDaoSupport{
     //dao层统计二级分类的方法
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO中分页查询的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin,
						limit));
		return list;
	}

	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	

}
