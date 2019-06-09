package cn.itcast.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.estore.domain.Admin;
import cn.itcast.estore.utils.JDBCUtils;

public class AdminDao {

	public Admin login(Admin admin) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from adminuser where adminname= ? and password = ? ";
		Admin existAdmin;
		try {
			existAdmin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),
					admin.getAdminname(), admin.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return existAdmin;
	}

	public void save(Admin admin) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into adminuser values (?,?,?,?)";
		Object[] params = {
				admin.getAid(),
				admin.getAdminname(),
				admin.getPassword(),
				admin.getRole()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Admin findByAdminname(String adminname) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from adminuser where adminname = ?";
		Admin admin;
		try {
			admin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),adminname);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return admin;
	}

}
