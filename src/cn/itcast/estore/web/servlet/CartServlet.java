package cn.itcast.estore.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.Book;
import cn.itcast.estore.domain.Cart;
import cn.itcast.estore.domain.CartItem;
import cn.itcast.estore.service.BookService;
import cn.itcast.estore.utils.BaseServlet;

//购物模块Servlet
public class CartServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//展示购物车
	public String showMyCart(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//resp.sendRedirect(req.getContextPath()+"/jsps/cart/list.jsp");//
		//重定向又多一次请求
		//return null;
		return "/jsps/cart/list.jsp";
	}
	//获得购物车
	public Cart getCart(HttpServletRequest req){
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		return cart; 
	}
	
	//添加到购物车
	public String addCart(HttpServletRequest req,HttpServletResponse resp){
		String bid = req.getParameter("bid");
		int count = Integer.parseInt(req.getParameter("count"));
		BookService bookService = new BookService();
		Book book = bookService.findByBid(bid);
		CartItem cartItem = new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		Cart cart = getCart(req);// 从session中获得购物车的信息.
		cart.addCart(cartItem);
		return "/jsps/cart/list.jsp";
	}
	
	//清空购物车
	public String clearCart(HttpServletRequest req,HttpServletResponse resp){
		Cart cart = getCart(req);
		cart.clearCart();
		return "/jsps/cart/list.jsp";
	}
	//移除购物项
	public String removeCart(HttpServletRequest req,HttpServletResponse resp){
		Cart cart = getCart(req);
		String bid = req.getParameter("bid");
		cart.removeCart(bid);
		return "/jsps/cart/list.jsp";
	}
}
