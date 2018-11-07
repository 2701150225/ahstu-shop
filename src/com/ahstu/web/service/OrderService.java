package com.ahstu.web.service;

import com.ahstu.web.dao.OrderDao;

/**
 * 订单业务层代码
 * @安科 王宿生
 *
 */
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
