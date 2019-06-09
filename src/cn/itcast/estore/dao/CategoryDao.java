package cn.itcast.estore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.estore.domain.Category;
import cn.itcast.estore.utils.JDBCUtils;

//分类dao
public class CategoryDao {

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from category";
		List<Category> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	public void save(Category category) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into category values (?,?)";
		Object[] param = {category.getCid(),category.getCname()};
		try {
			queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Category findByCid(String cid) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from category where cid = ?";
		Category category;
		try {
			category = queryRunner.query(sql, new BeanHandler<>(Category.class),cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return category;
	}

	public void update(Category category) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update category set cname =? where cid = ?";
		try {
			queryRunner.update(sql, category.getCname(),category.getCid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * DAO中删除分类的方法
	 * @param cid
	 */
	public void delete(String cid) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		// 先修改图书表的外键:
		String sql = "update book set cid = null where cid = ?";
		try {
			queryRunner.update(sql, cid);
			sql = "delete from category where cid = ?";
			queryRunner.update(sql, cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
