package cn.itcast.estore.web.servlet;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.estore.domain.Book;
import cn.itcast.estore.domain.Category;
import cn.itcast.estore.service.BookService;
import cn.itcast.estore.service.CategoryService;
import cn.itcast.estore.utils.BaseServlet;
import cn.itcast.estore.utils.UUIDUtils;

//后台分类管理的Servlet
public class AdminCategoryServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 查看所有分类
	public String findAll(HttpServletRequest req, HttpServletResponse resp) {
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		req.setAttribute("list", list);
		return "/adminjsps/admin/category/list.jsp";
	}
	//展示某一个分类的图书
	public String findByCid(HttpServletRequest req,HttpServletResponse resp){
		String cid =req.getParameter("cid");
		// 调用业务层根据ID查询分类
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findByCid(cid);
		req.setAttribute("category", category);
		BookService bookService = new BookService();
		List<Book> list = bookService.findByCid(cid);
		req.setAttribute("list", list);
		return "/adminjsps/admin/category/clist.jsp";
	}
		

	// 跳转到添加页面的方法:
	public String saveUI(HttpServletRequest req, HttpServletResponse resp) {
		return "/adminjsps/admin/category/add.jsp";
	}

	// 添加分类
	public String save(HttpServletRequest req, HttpServletResponse resp) {
		CategoryService categoryService = new CategoryService();
		String cname = req.getParameter("cname");
		// 数据封装:
		Category category = new Category();
		category.setCid(UUIDUtils.getUUID());
		category.setCname(cname);
		categoryService.save(category);
		// 页面跳转:
		return findAll(req,resp);
	}
	
	
	//编辑分类的方法:
	public String edit(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数:
		String cid = req.getParameter("cid");
		// 调用业务层根据ID查询分类
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findByCid(cid);
		// 页面跳转
		req.setAttribute("category", category);
		return "/adminjsps/admin/category/mod.jsp";
	}
	//修改分类
	public String update(HttpServletRequest req, HttpServletResponse resp){
		CategoryService categoryService = new CategoryService();
		Map<String, String[]> map = req.getParameterMap();
		Category category = new Category();
		try {
			BeanUtils.populate(category, map);
			// 调用业务层修改分类:
			categoryService.update(category);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		// 页面跳转:
		return findAll(req,resp);
	}
	
	
	//删除分页类页面:显示其分类下的图书;
	public String deleteUI(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数:
		String cid = req.getParameter("cid");
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findByCid(cid);
		// 页面跳转
		req.setAttribute("category", category);
		
		BookService bookService = new BookService();
		List<Book> list = bookService.findByCid(cid);
		req.setAttribute("list", list);
		return "/adminjsps/admin/category/del.jsp";
	}
	
	
	//删除分类的方法:
	public String delete(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数:
		String cid = req.getParameter("cid");
		// 调用业务层:
		CategoryService categoryService = new CategoryService();
		categoryService.delete(cid);
		// 页面跳转
		return findAll(req,resp);
	}
	

}
