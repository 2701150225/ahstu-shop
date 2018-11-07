package com.ahstu.web.pojo;
/**
  *   
 * @安科 王宿生
 *购买商品项对象
 */
public class ShopItem {
     private Product product ;  //商品信息
     private int count; //商品数量
     private  double subtotal;  //商品小计
     
     
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getShop_price();
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
     
}
