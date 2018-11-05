
package com.ahstu.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahstu.web.pojo.Product;
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


	
	
  

}