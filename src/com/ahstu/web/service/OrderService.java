package com.ahstu.web.service;

import org.springframework.transaction.annotation.Transactional;

import com.ahstu.web.dao.OrderDao;
import com.ahstu.web.pojo.Order;

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

	public void save(Order order) {
	orderDao.save(order);
		
	}

}
