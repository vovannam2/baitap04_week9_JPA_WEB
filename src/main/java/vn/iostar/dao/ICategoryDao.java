package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Category;

public interface ICategoryDao {

	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> findAll();

	Category findByCategoryname(String name) throws Exception;

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

}
