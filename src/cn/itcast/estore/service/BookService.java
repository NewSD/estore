package cn.itcast.estore.service;

import java.util.List;

import cn.itcast.estore.dao.BookDao;
import cn.itcast.estore.domain.Book;

public class BookService {

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		return bookDao.findAll();
	}

	public List<Book> findByCid(String cid) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		return bookDao.findByCid(cid);
	}

	public Book findByBid(String bid) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		return bookDao.findByBid(bid);
	}

}
