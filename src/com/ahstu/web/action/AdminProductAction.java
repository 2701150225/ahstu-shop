package com.ahstu.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.ahstu.web.pojo.CategorySecond;
import com.ahstu.web.pojo.Product;
import com.ahstu.web.service.CategorySecondService;
import com.ahstu.web.service.ProductService;
import com.ahstu.web.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台商品管理的Action
 * 
 * @安科 王宿生
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product = new Product();

	public Product getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	// 接收page参数
	private Integer page;
	// 注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// 注入CategorySecondService
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// 文件上传需要的三个属性:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// 后台管理查询商品的方法
	public String findAll() {
		// 调用Service完成查询操作
		PageBean<Product> pageBean = productService.findPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 跳转到添加页面的方法:
	public String addPage() {
		// 查询所有的二级分类:
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将二级分类的数据显示到页面上
		ActionContext.getContext().getValueStack().set("csList", csList);
		// 页面跳转
		return "addPageSuccess";
	}

	// 保存商品的方法:
	public String save() throws IOException {
		// 将提交的数据添加到数据库中.
		product.setPdate(new Date());
		// product.setImage(image);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
}
