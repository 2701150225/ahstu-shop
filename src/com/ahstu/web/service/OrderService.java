package com.ahstu.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ahstu.web.dao.OrderDao;
import com.ahstu.web.pojo.Order;

import com.ahstu.web.utils.PageBean;

/**
 * 订单业务层代码
 * @安科 王宿生
 *
 */

@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
    //生成订单业务层代码
	public void save(Order order) {
	orderDao.save(order);
		
	}
    //用户订单查询业务层代码
	public PageBean<Order> findPageUid(Integer uid, Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);//设置当前页数
		
		Integer limit=5;//设置每页显示记录数
		pageBean.setLimit(limit);
	    
	    int totalCount=0;//设置总记录数
	    totalCount =orderDao.findCountUid(uid);
	    pageBean.setTotalCount(totalCount);
	    
	    Integer totalPage=null;//设置总页数
		if(totalCount %limit==0) {
			
			totalPage=totalCount/limit;
		}
		else {
			
			totalPage=totalCount/limit +1;
		}
		pageBean.setTotalPage(totalPage);
		
		
		Integer begin=(page-1)*limit;
		List<Order>  list=orderDao.findPageUid(uid,begin,limit);//设置每页显示数据集合
		pageBean.setList(list);
		
		return pageBean;
	}
	
	//根据订单id查询订单
	public Order findOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOid(oid);
	}
	
	//修改订单
	public void update(Order currOrder) {
	orderDao.update(currOrder);
	}

}
