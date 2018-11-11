/**
 * 
 */
package com.ahstu.web.service;


import java.util.List;
import java.util.Locale.Category;

import com.ahstu.web.dao.TopcategoryDao;
import com.ahstu.web.pojo.Topcategory;

/**
 * @author wss
 *
 */
public class TopcategoryService {
 
	//zhuchuTopcategorydao
	private TopcategoryDao  topcategoryDao;


	public void setTopcategoryDao(TopcategoryDao topcategoryDao) {
		this.topcategoryDao = topcategoryDao;
	}


	
	public List<Topcategory> findAll() {
		return topcategoryDao.findAll();
	}



	public void save(Topcategory topcategory) {
		topcategoryDao.save(topcategory);
	}


//根据Cid查询一级分类
	public Topcategory findCid(Integer cid) {
	
		return topcategoryDao.findCid(cid);
	}



	public void delete(Topcategory topcategory) {
		// TODO Auto-generated method stub
		topcategoryDao.delete(topcategory);  
	}


//修改一级分类的方法
	public void update(Topcategory topcategory) {
		topcategoryDao.update(topcategory);
		
	}


   //保存一级分类的方法


	
}
