package com.ahstu.web.action;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 首页访问
 * @author wss
 *
 */
public class IndexAction extends ActionSupport{

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		
		return "index";
	}
	
	
}
