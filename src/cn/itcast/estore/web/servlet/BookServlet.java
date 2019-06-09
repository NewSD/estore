package cn.itcast.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.Book;
import cn.itcast.estore.service.BookService;
import cn.itcast.estore.utils.BaseServlet;

//图书模块Servlet
public class BookServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//展示所有分类下的图书
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		BookService bookService = new BookService();
		List<Book> list = bookService.findAll();
		req.setAttribute("list", list);
		return "/jsps/book/list.jsp";
	}
	
	//展示某一个分类的图书
	public String findByCid(HttpServletRequest req,HttpServletResponse resp){
		BookService bookService = new BookService();
		String cid =req.getParameter("cid");
		List<Book> list = bookService.findByCid(cid);
		req.setAttribute("list", list);
		return "/jsps/book/list.jsp";
	}
	
	//展示图书的详情
	public String findByBid(HttpServletRequest req,HttpServletResponse resp){
		BookService bookService = new BookService();
		String bid =req.getParameter("bid");
		Book book = bookService.findByBid(bid);
		req.setAttribute("book", book);
		return "/jsps/book/desc.jsp";
	}
}
