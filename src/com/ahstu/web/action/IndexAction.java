package com.ahstu.web.action;

import java.util.List;

import com.ahstu.web.pojo.Topcategory;
import com.ahstu.web.service.TopcategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
;

/**
 * 首页访问
 * @author wss
 *
 */
public class IndexAction extends ActionSupport{
    //注入TopcategoryService
	// 注入一级分类的Service:
		private TopcategoryService topcategoryService;

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
		return "index";
	}
	
}
