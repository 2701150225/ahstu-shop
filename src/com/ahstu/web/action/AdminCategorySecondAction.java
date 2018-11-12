package com.ahstu.web.action;


import java.util.List;

import com.ahstu.web.pojo.CategorySecond;
import com.ahstu.web.pojo.Topcategory;
import com.ahstu.web.service.CategorySecondService;
import com.ahstu.web.service.TopcategoryService;
import com.ahstu.web.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
  //模型驱动使用的对象
	private CategorySecond  categorySecond=new CategorySecond();
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
     //注入二级分类的Service
	private CategorySecondService  categorySecondService;
	// 注入一级分类的Service
		private TopcategoryService topcategoryService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	
	public void setTopcategoryService(TopcategoryService topcategoryService) {
		this.topcategoryService = topcategoryService;
	}
	//接收页数
	private  Integer page;
	

    public void setPage(Integer page) {
		this.page = page;
	}


	//查询所有二级分类的方法
	public String findAll() {
		// 调用Service进行查询.
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		// 将pageBean的数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
		
	// 跳转到添加页面的方法:
		public String addPage() {
			// 查询所有一级分类.
			List<Topcategory> cList = topcategoryService.findAll();
			// 将集合存入到值栈中.
			ActionContext.getContext().getValueStack().set("cList", cList);
			// 页面跳转:
			return "addPage";
		}
		// 添加二级分类的方法:
		public String save() {
			categorySecondService.save(categorySecond);
			return "saveSuccess";
		}


}
