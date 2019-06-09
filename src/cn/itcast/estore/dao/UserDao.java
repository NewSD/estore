package cn.itcast.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.estore.domain.User;
import cn.itcast.estore.utils.JDBCUtils;

public class UserDao {

	//保存用户
	public void save(User user) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?)";
		Object[] params = {
				user.getUid(),
				user.getUsername(),
				user.getPassword(),
				user.getEmail(),
				user.getState(),
				user.getCode()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	//查询用户名是否存在
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username= ?";
		User user;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return user;
	}

	//查询激活码的用户
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code = ?";
		User user;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),code);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return user;
	}

	//修改用户的方法
	public void update(User user) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username = ?,password = ?,email = ?,state = ?,code = ? where uid = ?";
		Object[] params = {
				user.getUsername(),
				user.getPassword(),
				user.getEmail(),
				user.getState(),
				user.getCode(),
				user.getUid(),};
		try {
			queryRunner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username= ? and password = ? and state = ?";
		Object[] params={user.getUsername(),user.getPassword(),1} ;
		User existUser;
		try {
			//existUser = queryRunner.query(sql, params, new BeanHandler<User>(User.class));
			existUser = queryRunner.query(sql, new BeanHandler<User>(User.class),
					user.getUsername(), user.getPassword(), 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return existUser;
	}

}
