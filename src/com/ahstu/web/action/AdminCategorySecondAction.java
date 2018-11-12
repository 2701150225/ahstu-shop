package com.ahstu.web.action;


import com.ahstu.web.pojo.CategorySecond;
import com.ahstu.web.service.CategorySecondService;
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
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
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
		

}
