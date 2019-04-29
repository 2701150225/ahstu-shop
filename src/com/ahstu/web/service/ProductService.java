
package com.ahstu.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahstu.web.pojo.Product;
import com.ahstu.web.utils.PageBean;

import com.ahstu.web.dao.ProductDao;

/**
 * 二手商品的业务层逻辑代码
 * @安科 王宿生
 * 
 */
@Transactional
public class ProductService {
    private ProductDao productDao;//注入productDao


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}




	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}




	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}




	public Product findPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findPid(pid);
	}




	public PageBean<Product> findPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		//  设置总记录数:
		int totalCount = 0 ;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}




	public PageBean<Product> findPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		//  设置总记录数:
		int totalCount = 0 ;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}



// 后台查询所有商品带分页

	public PageBean<Product> findPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 10;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = productDao.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数:
			int totalPage = 0;
			// Math.ceil(totalCount / limit);
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 每页显示的数据集合:
			// 从哪开始:
			int begin = (page - 1) * limit;
			List<Product> list = productDao.findPage(begin, limit);
			pageBean.setList(list);
			return pageBean;
		}





	// 业务层保存商品方法:
	public void save(Product product) {
		productDao.save(product);
	}




	public void delete(Product product) {
	   productDao.delete(product);
		
	}

	}


