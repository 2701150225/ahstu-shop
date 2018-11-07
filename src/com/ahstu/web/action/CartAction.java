package com.ahstu.web.action;

import org.apache.struts2.ServletActionContext;

import com.ahstu.web.pojo.Cart;
import com.ahstu.web.pojo.Product;
import com.ahstu.web.pojo.ShopItem;
import com.ahstu.web.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @安科 王宿生
 *
 */
public class CartAction extends ActionSupport {
  
	private Integer pid;//接收商品ID
	private Integer count;//接收数量
	private ProductService productService;
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String addCart() {
		ShopItem shopItem =new ShopItem();//封装shopItem对象
		shopItem.setCount(count);//设置数量
		Product product= productService.findPid(pid);//根据pid查询商品
		 shopItem.setProduct(product);//设置商品
		 Cart cart=getCart();//将商品添加到购物车
		 cart.addCart(shopItem);//购物车存在session中
		 
		return "addCart";
	}
	//移除购物车商品的方法
	  public String remove() {
		 Cart cart=getCart();//获得购物车对象
		 cart.removeCart(pid);//调用购物车remove方法
		 return "removeCart";
		 
		 
	  }
//清空购物车的方法	  
	  public String clear() {
		  Cart cart=getCart();//获得购物车对象
		  cart.clearCart();//调用购物车clear方法
		  
		  return "clearCart";
		  
	  }
	
   //从session中获得购物车
	private Cart getCart() {
	  Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
	  if(cart == null) {
		 cart= new Cart();
		  ServletActionContext.getRequest().getSession().setAttribute("cart",cart);
	  }
		
		return cart;
	}
}
