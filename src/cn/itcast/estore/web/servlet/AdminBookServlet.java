package cn.itcast.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.Book;
import cn.itcast.estore.domain.Category;
import cn.itcast.estore.service.BookService;
import cn.itcast.estore.service.CategoryService;
import cn.itcast.estore.utils.BaseServlet;
/**
 * 后台图书管理的Servlet:
 */
public class AdminBookServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 后台查询所有图书的方法;
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		// 调用业务层:
		BookService bookService = new BookService();
		List<Book> list = bookService.findAll();
		// 页面跳转:
		req.setAttribute("list", list);
		return "/adminjsps/admin/book/list.jsp";
	}
	
}
