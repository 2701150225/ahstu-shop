package com.ahstu.web.action;

import java.util.List;

import com.ahstu.web.pojo.Product;
import com.ahstu.web.pojo.Topcategory;
import com.ahstu.web.service.ProductService;
import com.ahstu.web.service.TopcategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
;

/**
 * 首页访问
 * @安科 王宿生
 *
 */
public class IndexAction extends ActionSupport{
    
	
		private TopcategoryService topcategoryService;// 注入一级分类的Service:
        public void setProductService(ProductService productService) {
			this.productService = productService;
		}
		


		private ProductService productService;//注入商品的Service
	
		public void setTopcategoryService(TopcategoryService topcategoryService) {
			this.topcategoryService = topcategoryService;
		}

	
	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		//查询一级分类
		
		// 查询所有一级分类集合
		List<Topcategory> cList = topcategoryService.findAll();
		// 将一级分类存入到Session的范围:
		ActionContext.getContext().getSession().put("cList", cList);
		List<Product> hList = productService.findHot();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// 查询最新商品:
		List<Product> nList = productService.findNew();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	
}
