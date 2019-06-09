package cn.itcast.estore.service;

import cn.itcast.estore.dao.AdminDao;
import cn.itcast.estore.domain.Admin;
import cn.itcast.estore.utils.UUIDUtils;

public class AdminService {

	public Admin login(Admin admin) {
		AdminDao adminDao = new AdminDao();
		return adminDao.login(admin);
	}

	public Admin findByAdminname(String adminname) {
		AdminDao adminDao = new AdminDao();
		return adminDao.findByAdminname(adminname);
	}

	public void regist(Admin admin) {
		AdminDao adminDao = new AdminDao();
		admin.setAid(UUIDUtils.getUUID());
		adminDao.save(admin);
	}

}
