package com.ahstu.web.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.ahstu.web.pojo.Cart;
import com.ahstu.web.pojo.Order;
import com.ahstu.web.pojo.OrderItem;
import com.ahstu.web.pojo.ShopItem;
import com.ahstu.web.pojo.User;
import com.ahstu.web.service.OrderService;
import com.ahstu.web.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



/**
 * 订单管理Action
 * @安科 王宿生
 *
 */
public class OrderAction  extends ActionSupport implements ModelDriven<Order>{
    public Order order =new Order();//模型驱动使用的对象
    private OrderService orderService;//注入orderService
    private Integer page;//接收Page
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	//注入orderService
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	//生成订单执行的方法
	 public String save() {
			// Order order = new Order();
			Cart cart = (Cart) ServletActionContext.getRequest().getSession()
					.getAttribute("cart");//从session中获得购物车信息，购物车存在session中
			if (cart == null) {           //判断购物车是否为空
				this.addActionMessage("亲!您还没有购物!");
				return "msg";
			}
			
			order.setTotal(cart.getTotal());   //设置订单的总金额即购物车统计的总金额
			
			order.setState(1);                 //设置订单的状态  1:未付款.
			
			order.setOrdertime(new Date());    // 设置订单时间
			
			User existUser = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("existUser");//从session获取用户信息 
			if (existUser == null) {           //判断用户是否登录
				this.addActionMessage("亲!您还没有登录!");
				return "msg";
			}
			order.setUser(existUser); // 设置订单关联的用户
			  
			// 设置订单项集合:
			for (ShopItem shopItem : cart.getShopItems()) {    //使用增强for循环
				// 订单项的信息从购物项获得的.
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(shopItem.getCount());
				orderItem.setSubtotal(shopItem.getSubtotal());
				orderItem.setProduct(shopItem.getProduct());
				orderItem.setOrder(order);

				order.getOrderItems().add(orderItem);
			}
			orderService.save(order);
		 return "save";
	 }
	 
	 //用户订单列表查询执行的方法
	 public String  findUid() {
		 //根据用户Id查询
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		//调用Service
		PageBean<Order>  pageBean= orderService.findPageUid(user.getUid(),page );
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findUid";
	 }
}
