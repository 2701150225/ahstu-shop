
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




	public PageBean<Product> findPageCid(Integer cid, int currentPage) {
		PageBean<Product> pageBean = new PageBean<Product>(); 
		pageBean.setCurrentPage(currentPage);//设置当前页数
		int pageSize =8;
		pageBean.setPageSize(pageSize);//设置每页记录数
		int totalCount=0;
		totalCount=productDao.findCountPid(cid);
		pageBean.setTotalCount(totalCount);//设置总记录数
		int totalPage=0;                   
		//Math.ceil(totalCount/pageSize);ceil向上取整
		if(totalCount % pageSize == 0){
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount / pageSize  + 1;
		}
	    pageBean.setTotalPage(totalPage);//设置总页面数
	    
	    int start=(currentPage-1)*pageSize;
	     List<Product> list=productDao.findPageCid(cid,start,pageSize);//每页显示的数据集合
	     pageBean.setList(list);
		return pageBean;
	}




	
	
  

}