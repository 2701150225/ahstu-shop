package com.ahstu.web.action;

import com.ahstu.web.pojo.Product;
import com.ahstu.web.service.ProductService;
import com.ahstu.web.service.TopcategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @安科 王宿生
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
     private Product product=new Product();
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private ProductService productService;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	private Integer cid;  //接收分类的cid
	public void setTopcategoryService(TopcategoryService topcategoryService) {
		this.topcategoryService = topcategoryService;
	}
	private TopcategoryService topcategoryService;//注入一级分类Seriv 
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
     public String findPid() {
    	 product=productService.findPid(product.getPid());
    	 return "findPid";
     }
     
     
     
      public String findCid() {
    	  
    	  
    	  return "findCid";
      }
	 
}
