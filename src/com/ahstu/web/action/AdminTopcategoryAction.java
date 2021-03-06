package com.ahstu.web.action;
import java.util.List;

import com.ahstu.web.pojo.Topcategory;
import com.ahstu.web.service.TopcategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台一级分类管理
 * @安科 王宿生
 *
 */
public class AdminTopcategoryAction  extends ActionSupport implements ModelDriven<Topcategory> {
	//模型驱动使用的对象
	private Topcategory topcategory = new Topcategory();
	public Topcategory getModel() {
		return topcategory;
	}
	// 注入一级分类的Service
		public TopcategoryService topcategoryService;
	public void setTopcategoryService(TopcategoryService topcategoryService) {
			this.topcategoryService = topcategoryService;
		}



	// 查询所有一级分类
	public String findAll(){
		// 调用Service查询所有一级分类
		List<Topcategory> cList = topcategoryService.findAll();
		// 通过值栈保存一级分类集合:
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	public  String save() {
		topcategoryService.save(topcategory);
		return "save";
		
		
	}
	//后台管理一级分类的删除
	public  String delete() {
		//接收cid，可以使用模型驱动，删除一级分类，必须根据id查询，最后再删除
	topcategory=topcategoryService.findCid(topcategory.getCid());
	topcategoryService.delete(topcategory);
		return "delete";
	}
	
	//
	public String edit() {
		
		
		topcategory=topcategoryService.findCid(topcategory.getCid());
		return "edit";
	}
	
	
	public String update() {
		topcategoryService.update(topcategory);
		
		return "update" ;
	}
}