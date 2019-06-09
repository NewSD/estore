package cn.itcast.estore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.estore.domain.Book;
import cn.itcast.estore.utils.JDBCUtils;

public class BookDao {

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from book where isdel = ?";// isdel 0:上架   1:下架
		List<Book> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<>(Book.class), 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	public List<Book> findByCid(String cid) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from book where isdel = ? and cid = ?";// isdel 0:上架   1:下架
		List<Book> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<>(Book.class), 0, cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	public Book findByBid(String bid) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from book where bid = ?";
		Book book;
		try {
			book = queryRunner.query(sql, new BeanHandler<>(Book.class), bid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return book;
	}

}
