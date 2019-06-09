package cn.itcast.estore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.estore.domain.User;
import cn.itcast.estore.service.UserService;
import cn.itcast.estore.utils.BaseServlet;

/**
 * 
 *	用户的Servlet
 */
public class UserServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//注册的方法
	public String regist(HttpServletRequest req,HttpServletResponse resp){
		Map<String, String[]> parameterMap = req.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
			UserService userService = new UserService();
			userService.regist(user);//注册用户
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("msg", "用户注册成功,请去邮箱激活!");
		return "/jsps/msg.jsp";
	}
	//用户名校验AJAX异步
	public String checkUsername(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String username = req.getParameter("username");
		UserService userService = new UserService();
		User user = userService.findByUsername(username);
		if(user == null){
			// 用户名可以使用
			resp.getWriter().println(1);
		}else{
			// 用户名不可以使用
			resp.getWriter().println(2);
		}
		return null;
	}
	
	
	
	
	//用户邮箱激活
	public String active(HttpServletRequest req,HttpServletResponse resp){
		String code = req.getParameter("code");
		UserService userService = new UserService();
		User user = userService.findByCode(code);
		if (user != null){
			user.setState(1);
			user.setCode(null);
			userService.update(user);
			req.setAttribute("msg", "激活成功,可以登录!");
		}else{
			// 直接保存信息跳转页面
			req.setAttribute("msg", "激活码不正确!");
		}
		return "/jsps/msg.jsp";
	}
	
	//登录
	public String login(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		User user =new User();
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(user, parameterMap);
			UserService userService = new UserService();
			User existUser = userService.login(user);
			if(existUser == null){
				req.setAttribute("msg", "用户名或密码错误或用户未激活!");
				return "/jsps/msg.jsp";
			}else{
				req.getSession().setAttribute("existUser", existUser);
				resp.sendRedirect(req.getContextPath()+"/jsps/main.jsp");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//退出用户
	public String logout(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		/**
		 * 1.获得session的信息.
		 * 2.销毁session的信息.这种方式会将session中的所有属性清除;
		HttpSession session = req.getSession();
		session.invalidate();
		 * 	;但是也可以只删除对应的属性
		 * 3.页面跳转:
		 */
		req.getSession().removeAttribute("existUser");
		resp.sendRedirect(req.getContextPath()+"/jsps/main.jsp");
		return null;
	}
}
