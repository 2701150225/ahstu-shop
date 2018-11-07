package com.ahstu.web.action;

import com.ahstu.web.pojo.Order;
import com.ahstu.web.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 订单管理Action
 * @安科 王宿生
 *
 */
public class OrderAction  extends ActionSupport implements ModelDriven<Order>{
    public Order order =new Order();
    private OrderService orderService;
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	 public String save() {
		 
		 
		 return "save";
	 }
}
