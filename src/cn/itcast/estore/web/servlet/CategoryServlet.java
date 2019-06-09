package cn.itcast.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.Category;
import cn.itcast.estore.service.CategoryService;
import cn.itcast.estore.utils.BaseServlet;

//分类模块Servlet
public class CategoryServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查看所有分类
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		req.setAttribute("list", list);
		return "/jsps/left.jsp";
	}
}
