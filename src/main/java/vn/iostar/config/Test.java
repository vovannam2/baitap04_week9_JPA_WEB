package vn.iostar.config;

import jakarta.persistence.*;
import vn.iostar.entity.Category;
import vn.iostar.entity.Video;

public class Test {
	public static void main(String[] args) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		Category cate = new Category();
		cate.setCategoryname("Iphone");

		cate.setImages("abc.jpg");

		cate.setStatus(1);

		
		try {

			trans.begin();
			enma.persist(cate);
		
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}
}
