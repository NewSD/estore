package cn.itcast.estore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.estore.domain.Admin;
import cn.itcast.estore.domain.User;
import cn.itcast.estore.service.AdminService;
import cn.itcast.estore.service.UserService;
import cn.itcast.estore.utils.BaseServlet;

//后台管理员Servlet
public class AdminServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//注册的方法
	public String regist(HttpServletRequest req,HttpServletResponse resp){
		Map<String, String[]> parameterMap = req.getParameterMap();
		Admin admin = new Admin();
		try {
			BeanUtils.populate(admin, parameterMap);
			AdminService adminService = new AdminService();
			adminService.regist(admin);//注册用户
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("msg", "用户注册成功,请登录!");
		return "/adminjsps/login.jsp";
	}
	//用户名校验AJAX异步
	public String checkAdminname(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String adminname = req.getParameter("adminname");
		AdminService adminService = new AdminService();
		Admin admin = adminService.findByAdminname(adminname);
		if(admin == null){
			// 用户名可以使用
			resp.getWriter().println(1);
		}else{
			// 用户名不可以使用
			resp.getWriter().println(2);
		}
		return null;
	}
	//登录
	public String login(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Admin admin =new Admin();
		Map<String, String[]> parameterMap = req.getParameterMap();
		try {
			BeanUtils.populate(admin, parameterMap);
			AdminService adminService = new AdminService();
			Admin existAdmin = adminService.login(admin);
			if(existAdmin == null){
				req.setAttribute("msg", "用户名或密码错误!");
				return "/adminjsps/login.jsp";
			}else{
				req.getSession().setAttribute("existAdmin", existAdmin);
				resp.sendRedirect(req.getContextPath()+"/adminjsps/admin/index.jsp");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	//退出
	public String logout(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.getSession().removeAttribute("existAdmin");
		resp.sendRedirect(req.getContextPath()+"/adminjsps/admin/index.jsp");
		return null;
	}

}
