/**
 * 
 */
package com.ahstu.web.service;


import java.util.List;

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

	
}
