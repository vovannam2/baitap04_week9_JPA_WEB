package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDao;
import vn.iostar.entity.Category;
import vn.iostar.services.ICategoryServices;

public class CategoryServices implements ICategoryServices{

	ICategoryDao cateDao = new CategoryDao();
	@Override
	public int count() {
		
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public Category findByCategoryname(String name) throws Exception {
		return cateDao.findByCategoryname(name);
	}

	@Override
	public Category findById(int cateid) {
		// TODO Auto-generated method stub
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub
		cateDao.delete(cateid);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		cateDao.update(category);
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
	}

}
