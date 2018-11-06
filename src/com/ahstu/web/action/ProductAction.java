package com.ahstu.web.action;

import com.ahstu.web.pojo.Product;
import com.ahstu.web.service.ProductService;
import com.ahstu.web.service.TopcategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.ahstu.web.utils.PageBean;

/**
 * 
 * @安科 王宿生
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
     private Product product=new Product();	
     private ProductService productService;//注入商品Service
     private Integer cid; //接收分类的cid
     private TopcategoryService topcategoryService;//注入一级分类Service 
     private int currentPage;// 接收当前页数
	 public void setCurrentpage(int currentPage) {
		this.currentPage = currentPage;
	}

	


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	 
	public void setTopcategoryService(TopcategoryService topcategoryService) {
		this.topcategoryService = topcategoryService;
	}
	
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	
     //根据商品id进行查询商品
	public String findPid() {
    	 product=productService.findPid(product.getPid());//调用Service的方法完成商品的额查询
    	 return "findPid";
     }
     
      public String findCid() {  //根据一级分类id查询商品
    	PageBean <Product> pageBean=productService.findPageCid(cid,currentPage);
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);	  
    	  return "findCid";
      }
	 
}
