package com.ahstu.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahstu.web.dao.CategorySecondDao;
import com.ahstu.web.pojo.CategorySecond;
import com.ahstu.web.utils.PageBean;

/**
 * 
 * @安科 王宿生
 *
 */
@Transactional
public class CategorySecondService {
	// 注入Dao
		private CategorySecondDao categorySecondDao;

		public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
			this.categorySecondDao = categorySecondDao;
		}
 //业务层分页查询二级分类的方法
		public PageBean<CategorySecond> findByPage(Integer page) {
			PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

			// 设置参数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 10;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = categorySecondDao.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数:
			int totalPage = 0;
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 设置页面显示数据的集合:
			int begin = (page - 1) * limit;
			List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
		}
		public void save(CategorySecond categorySecond) {
		     categorySecondDao.save(categorySecond);
			
		}
}
