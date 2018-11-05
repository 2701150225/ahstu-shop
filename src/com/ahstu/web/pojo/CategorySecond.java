package com.ahstu.web.pojo;


import java.util.HashSet;
import java.util.Set;

import com.ahstu.web.pojo.Topcategory;
import com.ahstu.web.pojo.Product;

/**
 * 二级分类的实体
 * @安科 王宿生
 *
 */
public class CategorySecond {
	private Integer csid;
	private String csname;
	private Topcategory topcategory;// 所属一级分类.存的是一级分类的对象.
	private Set<Product> products = new HashSet<Product>();// 配置商品集合
	public Topcategory getTopcategory() {
		return topcategory;
	}
	public void setTopcategory(Topcategory topcategory) {
		this.topcategory = topcategory;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
