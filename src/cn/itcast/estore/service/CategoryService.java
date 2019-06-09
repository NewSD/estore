package cn.itcast.estore.service;

import java.util.List;

import cn.itcast.estore.dao.CategoryDao;
import cn.itcast.estore.domain.Category;

//分类Service
public class CategoryService {

	//查看所有分类
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findAll();
	}

	public void save(Category category) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.save(category);
	}

	public Category findByCid(String cid) {
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findByCid(cid);
	}

	public void update(Category category) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.update(category);
	}

	public void delete(String cid) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.delete(cid);
	}

}
