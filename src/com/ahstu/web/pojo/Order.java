package com.ahstu.web.pojo;
/**
 * 订单的实体类对象
 * @安科 王宿生
 *
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.ahstu.web.pojo.User;
public class Order {
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;//订单状态
	private String name;
	private String phone;
	private String addr;
	private User user;  //订单所属对象
   private Set<OrderItem> orderItems =new HashSet<OrderItem>();//订单中有多个订单项

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
