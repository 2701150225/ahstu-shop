package com.ahstu.web.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import com.ahstu.web.utils.PaymentUtil;
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
    private String  pd_FrpId; //接收支付通道编码
    private String r6_Order;//接收付款成功后传过来的
    private String r3_Amt;// 
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
	
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
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
	 //根据订单id查询订单详细
	public  String  findOid() {
		 
		order=orderService.findOid(order.getOid());
		
		return "findOid";
	}
	
	//订单支付
	public String payOrder() throws IOException {
		// 1.修改数据:
		Order currOrder = orderService.findOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());
		// 修改订单
		orderService.update(currOrder);
		// 2.完成付款:
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://192.168.36.69:8080/shop/order_callBack.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	// 付款成功后跳转回来的路径:
	public String callBack(){
		// 修改订单的状态:
		Order currOrder = orderService.findOid(Integer.parseInt(r6_Order));
		// 修改订单状态为2:已经付款:
		currOrder.setState(2);
		orderService.update(currOrder);
		this.addActionMessage("支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
		return "msg";
	}
	

	
	}
	 

